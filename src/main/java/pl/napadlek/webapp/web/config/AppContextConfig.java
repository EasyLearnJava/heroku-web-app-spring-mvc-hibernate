package pl.napadlek.webapp.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "pl.napadlek.webapp")
@Profile(value = "prod")
public class AppContextConfig {
}
