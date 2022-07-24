package com.jovan.sgparkingv2;

import com.jovan.sgparkingv2.proxies.CarparkAvailabilityProxy;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableBatchProcessing
public class SgParkingV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SgParkingV2Application.class, args);
	}

}
