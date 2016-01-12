package pl.napadlek.webapp;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static final Log LOG = LogFactory.getLog(App.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Arrays.asList(context.getBeanDefinitionNames())
				.forEach(s -> LOG.info(s + " bean definition exists upon startup."));
		LOG.info(context.getBean("stringTestBean").getClass());
	}
}
