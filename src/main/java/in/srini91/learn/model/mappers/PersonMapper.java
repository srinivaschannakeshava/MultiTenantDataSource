package in.srini91.learn.model.mappers;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import in.srini91.learn.dao.model.Person;
import in.srini91.learn.resp.model.PersonDTO;

@Component
public class PersonMapper extends PropertyMap<Person, PersonDTO> {

	@Override
	protected void configure() {
		map().setName(source.getName());
		map().setAge(source.getAge());
		map().setCountry(source.getCountry());
	}

}
