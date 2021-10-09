package in.srini91.learn.model.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import in.srini91.learn.dao.model.Person;
import in.srini91.learn.resp.model.PersonDTO;

@Component
public class PersonConverter implements Converter<Person, PersonDTO> {

	@Autowired
	private ModelMapper modelMapper;
	
	public PersonDTO convert(Person source) {
		return modelMapper.map(source, PersonDTO.class);
	}
	
	public List<PersonDTO> convertList(List<Person> sList){
		return sList.stream().map(this::convert).collect(Collectors.toList());
	}


}
