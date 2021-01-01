package in.srini91.learn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.srini91.learn.dao.model.Person;
import in.srini91.learn.dao.repo.PersonRepository;

@Service
@CacheConfig(cacheNames = "personCache")
public class PersonService {

	@Autowired
	private PersonRepository pRepo;

	@Cacheable(unless = "#result==null")
	public Person getPersonById(Integer id) {
		Optional<Person> personOption = pRepo.findById(id);
		if (personOption.isPresent())
			return personOption.get();
		throw new RuntimeException("Person with id:" + id + " not found");
	}

}
