package in.srini91.learn.config.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Aspect
@Service
@Order(2)
public class LoggingAspect {
	private static Logger LOG = LogManager.getLogger(LoggingAspect.class);

	@Before("execution (* in.srini91.learn..*(..))")
	public void beforeExec(JoinPoint jp) {
		MethodSignature sig = (MethodSignature) jp.getSignature();
		String className = sig.getDeclaringType().getName();
		String methodName = sig.getName();
		LOG.info("Before execution of : " + className + " Method :: " + methodName);

	}

	@After("execution (* in.srini91.learn..*(..))")
	public void afterExec(JoinPoint jp) {
		MethodSignature sig = (MethodSignature) jp.getSignature();
		String className = sig.getDeclaringType().getName();
		String methodName = sig.getName();
		LOG.info("After execution of : " + className + " Method :: " + methodName);
	}

	@Pointcut("within(in.srini91.learn.controller.PersonController))")
	public void printOnDbAccess() {

	}

	@After("printOnDbAccess()")
	public void loggingDbAccess() {
		LOG.warn("<------PersonController accessed------>");
	}

	@AfterReturning("execution(public * *.save(..))")
	public void loggingAdviceSave() {
		LOG.warn("<---New person added to system--->");
	}

	@Around("@annotation(in.srini91.learn.config.aspect.LogPerformance)")
	public Object aroundTheMethod(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature sig = (MethodSignature) pjp.getSignature();
		String className = sig.getDeclaringType().getName();
		String methodName = sig.getName();
		StopWatch watch = new StopWatch();
		watch.start();
		Object result = pjp.proceed();
		watch.stop();
		LOG.info("Execution Time of : " + className + " : method : " + methodName + " :: " + watch.getTotalTimeMillis()
				+ " ms :: seconds = " + watch.getTotalTimeSeconds());
		return result;
	}

}
