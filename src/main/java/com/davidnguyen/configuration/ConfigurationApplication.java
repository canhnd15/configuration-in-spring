package com.davidnguyen.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class ConfigurationApplication implements CommandLineRunner {
	private final ConfigProperties configProperties;

	public ConfigurationApplication(ConfigProperties configProperties) {
		this.configProperties = configProperties;
	}

	private static final Logger log = LoggerFactory.getLogger(ConfigurationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("---------properties---------");
		log.info("URL {}", configProperties.getUrl());
		log.info("USERNAME {}", configProperties.getUsername());
		log.info("PASSWORD {}", configProperties.getPassword());
	}
}
