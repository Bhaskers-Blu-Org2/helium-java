package com.microsoft.azure.helium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${azure.cosmosdb.key}")
	private String cosmosDBkey;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... varl) throws Exception {

	}
}
