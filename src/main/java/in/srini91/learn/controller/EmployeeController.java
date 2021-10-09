package in.srini91.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.srini91.learn.config.aspect.LogPerformance;
import in.srini91.learn.dao.model.Employee;
import in.srini91.learn.dao.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository eRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	@LogPerformance
	public List<Employee> getEmployeeList() {
		return eRepo.findAll();
//		return null;
	}

	@PostMapping
	public Employee saveEmployee(@Valid @RequestBody Employee Employee) {
		return eRepo.save(Employee);
	}

	@GetMapping(path = "{id}")
	@LogPerformance
	public Employee getEmployeeById(@PathVariable(name = "id", required = true) Integer id) {
		return eRepo.getOne(id);
	}

	@DeleteMapping(path = "{id}")
	public void deleteEmployeeById(@PathVariable(name = "id", required = true) Integer id) {
		eRepo.deleteById(id);
	}
}
