package in.srini91.learn.db.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiContextDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContext.getCurrentDb();
	}

}
