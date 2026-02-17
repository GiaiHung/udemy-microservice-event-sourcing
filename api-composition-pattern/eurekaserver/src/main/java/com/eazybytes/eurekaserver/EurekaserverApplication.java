package com.eazybytes.eurekaserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication implements CommandLineRunner {

	@Value("${mark.test}")
	private String markTest;

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
//		System.out.println(markTest);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(markTest);
	}
}
