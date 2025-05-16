package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class SoftlearningApplication {		

	public static void main(String[] args) {
		SpringApplication.run(SoftlearningApplication.class, args);

		System.out.println("\n*****   A P P L I C A T I O N    S T A R T E D   *****\n");
	}

	// @Bean
	// public ObjectMapper objectMapper() {
	// 	ObjectMapper mapper = new ObjectMapper();
	// 	mapper.registerModule(new JavaTimeModule());
	// 	mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	// 	return mapper;
	// }

}
