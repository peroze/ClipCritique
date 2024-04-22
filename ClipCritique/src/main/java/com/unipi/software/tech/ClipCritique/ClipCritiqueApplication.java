package com.unipi.software.tech.ClipCritique;

import com.unipi.software.tech.ClipCritique.model.Role;
import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.model.Video;
import com.unipi.software.tech.ClipCritique.model.authentication.RegisterRequest;
import com.unipi.software.tech.ClipCritique.repository.UserRepository;
import com.unipi.software.tech.ClipCritique.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ClipCritiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClipCritiqueApplication.class, args);
	}




	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList(
						"http://localhost:3000"
				)
		);
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	CommandLineRunner run (UserRepository userRepository, VideoRepository videoRepository) {
		return args ->{

			var admin = User.builder()
					.fullName("Admin")
					.email("cineticketbooking@gmail.com")
					.password("12345")
					.dateOfBirth(LocalDate.of(1999,6,6))
					.role(Role.ADMIN)
					.build();

			userRepository.save(admin);


			Video video = new Video("https://www.youtube.com/embed/yR7Vg7viWkU?si=N4U4iXE1q_7pq-EV",admin,"Τμήμα Πληροφορικής - Πανεπιστήμιο Πειραιώς");
			videoRepository.save(video);

		};
	}




}
