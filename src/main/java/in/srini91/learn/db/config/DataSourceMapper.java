package in.srini91.learn.db.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "datasource")
public class DataSourceMapper {

	private Map<String, Properties> configs = new HashMap<>();

	private Map<Object, Object> dataSourceMap = new HashMap<>();

	@PostConstruct
	private void populateDataSources() {
		configs.forEach((k, v) -> {
			dataSourceMap.put(k, createDatasource(k));
		});
	}

	private DataSource createDatasource(String dbName) {
		Properties prop = configs.get(dbName);
		if (prop != null) {
			HikariConfig config = new HikariConfig(prop);
			return new HikariDataSource(config);
		}
		return null;
	}

	public DataSource getDataSource(String dbName) {
		if (dataSourceMap.get(dbName) != null)
			return (DataSource) dataSourceMap.get(dbName);
		DataSource ds = createDatasource(dbName);
		if (ds != null)
			dataSourceMap.put(dbName, ds);
		return ds;

	}

}
