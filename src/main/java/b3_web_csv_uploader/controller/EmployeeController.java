package b3_web_csv_uploader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import b3_web_csv_uploader.entity.Employee;
import b3_web_csv_uploader.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("*")
public class EmployeeController {
	

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "Employee saved...";
	}
	
	@GetMapping("/load-all")
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
}
