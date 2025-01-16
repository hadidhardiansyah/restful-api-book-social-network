package com.hadid.book_network;

import com.hadid.book_network.entity.role.Role;
import com.hadid.book_network.repository.IRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class RestfulApiBookNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiBookNetworkApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(IRoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(
						Role.builder().name("USER").build()
				);
			}
		};
	}
}
