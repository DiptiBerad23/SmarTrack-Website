package com.tka.smartTrack.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartTrackApplication.class, args);
		System.err.println("App is started...");
	}
}
