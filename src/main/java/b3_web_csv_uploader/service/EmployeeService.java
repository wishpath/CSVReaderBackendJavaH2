package b3_web_csv_uploader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import b3_web_csv_uploader.entity.Employee;
import b3_web_csv_uploader.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public void save(Employee employee) {
		employeeRepository.save(employee);	
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
}
