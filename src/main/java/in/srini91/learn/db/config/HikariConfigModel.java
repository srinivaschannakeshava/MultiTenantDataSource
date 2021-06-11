package in.srini91.learn.db.config;

import lombok.Data;

@Data
public class HikariConfigModel {
	private String jdbcUrl;
	private String driver;
	private String username;
	private String password;
	private Integer maximumPoolSize;
	private Integer minIdle;
}
