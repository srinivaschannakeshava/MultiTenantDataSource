package in.srini91.learn.config.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Aspect
@Service
@Order(1)
public class ExceptionAspect {

	private static Logger LOG = LogManager.getLogger(ExceptionAspect.class);

	@AfterThrowing(pointcut = "execution(* in.srini91.learn..*(..))", throwing = "exception")
	public void processException(RuntimeException exception) {
		LOG.error("-handled by exception aspect->" + exception.getMessage());
	}
}
