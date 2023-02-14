package b3_web_csv_uploader.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import b3_web_csv_uploader.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
