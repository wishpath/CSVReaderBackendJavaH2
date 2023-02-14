package b3_web_csv_uploader.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import b3_web_csv_uploader.dao.EmployeeRepository;
import b3_web_csv_uploader.model.Employee;
import b3_web_csv_uploader.service.CSVReader;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private CSVReader csvReader;
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return "Employee saved...";
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return repository.findAll();
	}
	
//	@PostMapping("/employees/save-from-csv")
//	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException { //model, kuris importas
//	    boolean finished = false;
//	    String message = "";
//
//	    if (CSVReader.hasCSVFormat(file)) {
//	        try {
//	            csvReader.read(file);
//	            message = "Uploaded the file successfully: " + file.getOriginalFilename();
//	            finished = true;
//	        } catch (Exception e) {
//	            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//	            message += e;
//	            finished = true;
//	        }
//	    }
//	    
//	    
//	    if (!CSVReader.hasCSVFormat(file)){ //pertvarkyti į else
//	        message = "File is empty!";
//	    }
//	    
//	    
//	    if (!finished) {
//	        message = "Please upload a csv file!";
//	    }
//	    return message;
//	}
}
