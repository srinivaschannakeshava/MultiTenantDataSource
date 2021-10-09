package in.srini91.learn.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Employee  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5380597271983687093L;

	@Id
	@GeneratedValue
	private Integer id;

	@NotBlank
	private String name;
	
	private String role;
	
	@Min(value = 18,message = "Min Age of working is 18")
	private Integer age;
	
	@CreationTimestamp
	private Timestamp createdDate;

	@UpdateTimestamp
	private Timestamp modifiedDate;
	

}
