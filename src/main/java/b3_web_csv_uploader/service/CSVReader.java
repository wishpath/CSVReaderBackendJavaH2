package b3_web_csv_uploader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import b3_web_csv_uploader.dao.EmployeeRepository;
import b3_web_csv_uploader.entities.Employee;

@Service
public class CSVReader {

	@Autowired
	private EmployeeRepository repository;

	public static final String delimiter = ";";

	public void read(String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			String line = " ";
			String[] arr;

			while ((line = br.readLine()) != null) {
				arr = line.split(delimiter);
				repository.save(new Employee(arr[0], arr[1], arr[2]));
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static boolean hasCSVFormat(MultipartFile file) {
		String TYPE = "text/csv";
		return TYPE.equals(file.getContentType());
	}
}
