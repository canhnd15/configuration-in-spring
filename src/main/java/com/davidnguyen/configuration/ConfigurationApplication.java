package com.davidnguyen.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConfigurationApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ConfigurationApplication.class);
	private final Environment env;

	public ConfigurationApplication(Environment env) {
		this.env = env;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("---------Database Configuration---------");
		log.info("URL: {}", env.getProperty("DB_URL"));
		log.info("USERNAME: {}", env.getProperty("DB_USERNAME"));
		log.info("PASSWORD: {}", env.getProperty("DB_PASSWORD"));
	}
}
