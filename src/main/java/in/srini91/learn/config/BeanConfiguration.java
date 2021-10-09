package in.srini91.learn.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.srini91.learn.aop.introductions.Flight;
import in.srini91.learn.dao.model.Person;
import in.srini91.learn.db.config.DataSourceMapper;
import in.srini91.learn.db.config.MultiContextDataSource;
import in.srini91.learn.model.mappers.EmployeeConverter;
import in.srini91.learn.model.mappers.PersonMapper;
import in.srini91.learn.resp.model.PersonDTO;

@Configuration
public class BeanConfiguration {

	@Value("${default-db}")
	private String defaultDb;

	@Autowired
	private DataSourceMapper dsMap;
	
	@Autowired
	EmployeeConverter empConverter;

	@Bean
	public DataSource datasource() {
		MultiContextDataSource mcds = new MultiContextDataSource();
		mcds.setDefaultTargetDataSource(dsMap.getDataSource(defaultDb));
		mcds.setTargetDataSources(dsMap.getDataSourceMap());
		return mcds;
	}

	@Bean
	public Flight getFlight() {
		Flight flight = new Flight();
		flight.setCompany("ABC");
		flight.setId("ID 747");
		return flight;
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper=new ModelMapper();
		PropertyMap<Person, PersonDTO> propertyMap = new PropertyMap<Person, PersonDTO>() {

			@Override
			protected void configure() {
				map().setName(source.getName());
				map().setAge(source.getAge());
				map().setCountry("INDIA");
			}

		};
		modelMapper.addMappings(propertyMap);
		return modelMapper;
	}

}
