package in.srini91.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.Assert;

import in.srini91.learn.aop.introductions.Flight;
import in.srini91.learn.aop.introductions.Flyer;
import in.srini91.learn.aop.introductions.Flyer2;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableCaching
public class MultiTenantDataSourceApplication implements CommandLineRunner {

	@Autowired
	Flight flight;

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantDataSourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(flight.toString());

		Assert.isTrue(flight instanceof Flight, "Instance of Flight");
		Assert.isTrue(flight instanceof Flyer, "Instance of Flyer");

		((Flyer) flight).takeOff();
		((Flyer) flight).fly();
		((Flyer) flight).land();
		((Flyer2) flight).roll();
		((Flyer) flight).execute();

	}

}
