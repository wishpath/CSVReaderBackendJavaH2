package b3_web_csv_uploader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import b3_web_csv_uploader.dao.EmployeeRepository;
import b3_web_csv_uploader.entities.Employee;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		repository.save(employee);
		return "Employee saved...";
	}

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return repository.findAll();
	}

}
