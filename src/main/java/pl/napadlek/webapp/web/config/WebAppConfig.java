package pl.napadlek.webapp.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "pl.napadlek.webapp")
@Profile(value = { "dev", "test" })
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ObjectMapper jacksonObjectMapper() {
		return new Jackson2ObjectMapperFactoryBean().getObject();
	}

	@Bean
	public ViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		SpringTemplateEngine engine = new SpringTemplateEngine();
		ServletContextTemplateResolver contextResolver = new ServletContextTemplateResolver();
		contextResolver.setPrefix("/pages/");
		contextResolver.setSuffix(".html");
		contextResolver.setTemplateMode("HTML5");
		contextResolver.setCacheable(false);
		contextResolver.setCharacterEncoding("UTF-8");
		engine.setTemplateResolver(contextResolver);
		resolver.setTemplateEngine(engine);
		resolver.setCache(false);
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
}
