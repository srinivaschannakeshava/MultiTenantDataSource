package in.srini91.learn.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.srini91.learn.db.config.DataSourceMapper;
import in.srini91.learn.db.config.MultiContextDataSource;

@Configuration
public class BeanConfiguration {

	@Value("${default-db}")
	private String defaultDb;

	@Autowired
	private DataSourceMapper dsMap;

	@Bean
	public DataSource datasource() {
		MultiContextDataSource mcds = new MultiContextDataSource();
		mcds.setDefaultTargetDataSource(dsMap.getDataSource(defaultDb));
		mcds.setTargetDataSources(dsMap.getDataSourceMap());
		return mcds;
	}

}
