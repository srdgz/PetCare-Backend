package com.petcare_backend.petcare;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetcareApplication {

	public static void main(String[] args) {
		Dotenv.configure()
				.directory("C:\\Users\\Sandra\\Desktop\\PetCare-Backend\\.env")
				.load();
		SpringApplication.run(PetcareApplication.class, args);
	}

}
