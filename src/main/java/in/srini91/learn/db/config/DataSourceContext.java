package in.srini91.learn.db.config;

/**
 * @author srini
 *
 */
public class DataSourceContext {

	private DataSourceContext() {
	}

	private static ThreadLocal<String> currentRequest = new ThreadLocal<>();

	public static String getCurrentDb() {
		return currentRequest.get();
	}

	public static void setCurrentDb(String dbName) {
		currentRequest.set(dbName);
	}

	public static void clear() {
		currentRequest.remove();
	}

}
