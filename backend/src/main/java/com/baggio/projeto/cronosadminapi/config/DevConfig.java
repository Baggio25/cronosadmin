package com.baggio.projeto.cronosadminapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Bean
	public boolean instantiateDatabase( ) {
		return true;
	}

}
