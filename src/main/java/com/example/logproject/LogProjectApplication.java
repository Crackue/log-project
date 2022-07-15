package com.example.logproject;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogProjectApplication.class, args);
	}

	@Bean
	public H2ConnectionFactory connectionFactory() {
		return new H2ConnectionFactory(
				H2ConnectionConfiguration.builder()
						.url("mem:testdb;DB_CLOSE_DELAY=-1;TRACE_LEVEL_FILE=4")
						.username("sa")
						.build());
	}
}
