package in.srini91.learn.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1882611751646736765L;

	@Id
	@GeneratedValue
	private Integer id;

	@NotBlank
	private String name;

	private Integer age;

	@NotBlank
	private String country;
}
