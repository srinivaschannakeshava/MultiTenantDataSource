package in.srini91.learn.config.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Service;

import in.srini91.learn.aop.introductions.Flyer;
import in.srini91.learn.aop.introductions.Flyer2;
import in.srini91.learn.aop.introductions.FlyerImpl;

@Aspect
@Service
public class FlightAspect {

	@DeclareParents(value = "in.srini91.learn.aop.introductions.Flight", defaultImpl = FlyerImpl.class)
	private Flyer flyer;
	@DeclareParents(value = "in.srini91.learn.aop.introductions.Flight", defaultImpl = FlyerImpl.class)
	private Flyer2 flyer2;

	/*
	 * this example demonstrates the usefull ness of spring AoP introduction which
	 * helps in extending the features of a old implementation without touching the
	 * source code. Here we take a simple example of Flight class whose features is
	 * extended via AoP introduction concept with flyerImpl class.
	 */

}
