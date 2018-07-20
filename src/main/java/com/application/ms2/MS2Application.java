package com.application.ms2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//@EnableDiscoveryClient
////@EnableHystrixDashboard
//@EnableCircuitBreaker
public class MS2Application {

	public static void main(String[] args) {
		SpringApplication.run(MS2Application.class, args);
	}
}
