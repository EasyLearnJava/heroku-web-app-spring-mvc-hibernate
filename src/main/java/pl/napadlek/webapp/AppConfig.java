package pl.napadlek.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "pl.napadlek.webapp")
public class AppConfig {

	@Bean
	@Primary
	public String stringTestBean() {
		return "Hello world!";
	}
	
	@Bean
	public String anotherString() {
		return "Hi there!";
	}
	
	@Bean
	public Author famousAuthor() {
		Author author = new Author();
		author.setFirstName("Mark");
		author.setLastName("Twain");
		return author;
	}
}
