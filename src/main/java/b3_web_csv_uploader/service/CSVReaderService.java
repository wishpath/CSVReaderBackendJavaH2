package b3_web_csv_uploader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import b3_web_csv_uploader.entity.Employee;
import b3_web_csv_uploader.repository.EmployeeRepository;

@Service
public class CSVReaderService {

	@Autowired
	private EmployeeRepository repository;

	public static final String delimiter = ";";
	
	public void read(String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			String line;

			while ((line = br.readLine()) != null) {
				Employee employee = parseEmployee(line);
				repository.save(employee);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private Employee parseEmployee(String line) {
		String[] arr = line.split(delimiter);
		Employee employee = new Employee();
		employee.setName(arr[0]);
		employee.setEmail(arr[1]);
		employee.setPhone(arr[2]);
		return employee;
	}

	public static boolean hasCSVFormat(MultipartFile file) {
		String TYPE = "text/csv";
		return TYPE.equals(file.getContentType());
	}
}
