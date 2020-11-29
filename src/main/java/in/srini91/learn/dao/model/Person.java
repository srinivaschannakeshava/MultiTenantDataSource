package in.srini91.learn.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Integer age;

	private String country;
}
