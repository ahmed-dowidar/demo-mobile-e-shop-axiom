package com.gov.uae.axiom;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gov.uae.axiom.domain.Mobiles;
import com.gov.uae.axiom.service.MobileService;
import com.gov.uae.axiom.serviceImpl.MobileServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class MobileShopDemo {

	public static void main(String[] args) {
		SpringApplication.run(MobileShopDemo.class, args);
	}

	@Autowired
	private MobileService mobileService;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Mobiles>> typeReference = new TypeReference<List<Mobiles>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/mobiles.json");
			try {
				List<Mobiles> mobiles = mapper.readValue(inputStream, typeReference);
				mobileService.save(mobiles);
				System.out.println("mobiles Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save mobiles: " + e.getMessage());
			}
		};
	}
}
