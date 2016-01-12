package pl.napadlek.webapp;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "pl.napadlek.webapp")
@EnableAspectJAutoProxy
@EnableCaching
public class AppConfig {

	@Bean
	@Primary
	public String stringTestBean() {
		return "Hello world!";
	}

	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager();
	}
	
	@Bean
	public Author famousAuthor() {
		Author author = new Author();
		author.setFirstName("Mark");
		author.setLastName("Twain");
		return author;
	}
}
