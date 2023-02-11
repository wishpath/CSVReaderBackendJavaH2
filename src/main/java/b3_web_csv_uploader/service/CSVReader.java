package b3_web_csv_uploader.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import b3_web_csv_uploader.dao.EmployeeRepository;
import b3_web_csv_uploader.model.Employee;

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
//	  public static void main(String[] args) {
//	    //csv file to read
//	    String csvFile = "C:\\Users\\Dell\\Desktop\\csvDemo.csv";
//	    CSVReader.read(csvFile);
//	  }

	public static boolean hasCSVFormat(MultipartFile file) {
		String TYPE = "text/csv";
		return TYPE.equals(file.getContentType());
	}
	
	
//	public void csvToEmployees(@RequestParam("file") MultipartFile file, Model model) {
//	    // validate file
//	    if (file.isEmpty()) {
//	        model.addAttribute("message", "Please select a CSV file to upload.");
//	        model.addAttribute("status", false);
//	    } else {
//
//	        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//
//	            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
//	                    .withType(Employee.class)
//	                    .withIgnoreLeadingWhiteSpace(true)
//	                    .build();
//
//	            List users = csvToBean.parse();
//	            employeeRepository.saveAll(users);
//
//	            model.addAttribute("users", users);
//	            model.addAttribute("status", true);
//
//	        } catch (Exception ex) {
//	            model.addAttribute("message", "An error occurred while processing the CSV file.");
//	            model.addAttribute("status", false);
//	        }
//	    }
//	}

}
