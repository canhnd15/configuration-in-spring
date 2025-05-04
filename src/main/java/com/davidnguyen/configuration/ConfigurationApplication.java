package com.davidnguyen.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DatabaseConfigProperties.class)
public class ConfigurationApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ConfigurationApplication.class);
	private final DatabaseConfigProperties databaseConfigProperties;

	public ConfigurationApplication(DatabaseConfigProperties databaseConfigProperties) {
		this.databaseConfigProperties = databaseConfigProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("---------Database Configuration---------");
		log.info("URL: {}", databaseConfigProperties.getUrl());
		log.info("Username: {}", databaseConfigProperties.getUsername());
		log.info("Password: {}", databaseConfigProperties.getPassword() != null ? "*****" : "null");
	}
}
