package b3_web_csv_uploader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import b3_web_csv_uploader.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
