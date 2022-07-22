package com.jovan.sgparkingv2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SgParkingV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SgParkingV2Application.class, args);
	}

}
