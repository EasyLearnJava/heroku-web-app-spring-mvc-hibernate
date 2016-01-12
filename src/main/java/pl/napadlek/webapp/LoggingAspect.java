package pl.napadlek.webapp;

import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component(value = "loggingAspect")
@Aspect
public class LoggingAspect {

	public void beforeMethodLog(JoinPoint joinPoint) {
		LogFactory.getLog(joinPoint.getTarget().getClass())
				.info(joinPoint.getSignature().getName() + " executed.");
	}
}
