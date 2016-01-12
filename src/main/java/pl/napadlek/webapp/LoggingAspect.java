package pl.napadlek.webapp;

import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Configurable
@Profile(value = "logging")
public class LoggingAspect {

	@Before(value = "execution(public * *(..))")
	public void beforeMethodLog(JoinPoint joinPoint) {
		LogFactory.getLog(joinPoint.getTarget().getClass())
				.info(joinPoint.getSignature().getName() + " executed.");
	}
}
