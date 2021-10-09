package in.srini91.learn.model.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import in.srini91.learn.dao.model.Employee;
import in.srini91.learn.resp.model.EmployeeDTO;

@Component
public class EmployeeConverter implements Converter<Employee, EmployeeDTO>{

	@Override
	public EmployeeDTO convert(Employee source) {
		EmployeeDTO eDto=new EmployeeDTO();
		eDto.setId(source.getId());
		eDto.setName(source.getName());
		eDto.setRole(source.getRole());
		return eDto;
	}
	
	public List<EmployeeDTO> convert(List<Employee> eList){
		return eList.stream().map(this::convert).collect(Collectors.toList());
	}

}
