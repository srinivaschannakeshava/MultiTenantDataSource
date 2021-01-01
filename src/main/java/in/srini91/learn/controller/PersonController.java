package in.srini91.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.srini91.learn.config.aspect.LogPerformance;
import in.srini91.learn.dao.model.Person;
import in.srini91.learn.dao.repo.PersonRepository;
import in.srini91.learn.service.PersonService;

@RestController
@RequestMapping(path = "person")
public class PersonController {

	@Autowired
	private PersonRepository pRepo;

	@Autowired
	private PersonService pService;

	@GetMapping
	@LogPerformance
	public List<Person> getPersonList() {
		return pRepo.findAll();
	}

	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		return pRepo.save(person);
	}

	@GetMapping(path = "{id}")
	@LogPerformance
	public Person getPersonById(@PathVariable(name = "id", required = true) Integer id) {
		return pService.getPersonById(id);
	}

	@DeleteMapping(path = "{id}")
	public void deletePersonById(@PathVariable(name = "id", required = true) Integer id) {
		pRepo.deleteById(id);
	}
}
