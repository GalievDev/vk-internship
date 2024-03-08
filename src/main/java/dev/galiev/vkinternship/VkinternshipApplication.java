package dev.galiev.vkinternship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@SpringBootApplication
public class VkinternshipApplication {

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring()
				.anyRequest();
	}

	public static void main(String[] args) {
		SpringApplication.run(VkinternshipApplication.class, args);
	}

}
