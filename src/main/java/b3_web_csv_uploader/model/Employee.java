package b3_web_csv_uploader.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String phone;

	public Employee(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
}
