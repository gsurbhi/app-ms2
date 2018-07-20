package com.application.ms2;

import org.jboss.logging.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MS2Controller {

	
	RestTemplate restTemplate = new RestTemplate();
	
//	@Autowired
//	org.springframework.cloud.client.discovery.DiscoveryClient client;
//	
//	@Autowired
//	org.springframework.cloud.client.ServiceInstance serviceInstanceApp1;
//	
//	@Autowired
//	org.springframework.cloud.client.ServiceInstance serviceInstanceApp2;
//	

	@GetMapping(path="/ms2")
	//@HystrixCommand(fallbackMethod = "fallback")
	public int sum() {
		
//			serviceInstanceApp1= client.getInstances("ms1")
//			        .stream()
//			        .findFirst()
//			        .orElseThrow( () -> new RuntimeException("ms1 not found"));
//			
//			String url1  = serviceInstanceApp1.getUri().toString()+"/rest/ms1/firstnumber";
			String url1  = "http://localhost:4140/rest/ms1/firstnumber";
			//int number1 = restTemplate.getForObject(url1, Integer.class);
//			
//			serviceInstanceApp2 = client.getInstances("ms3")
//			        .stream()
//			        .findFirst()
//			        .orElseThrow( () -> new RuntimeException("ms3 not found"));
//			
//			String url2  = serviceInstanceApp2.getUri().toString()+"/rest/ms3/secondnumber";
			String url2  = "http://localhost:4140/rest/ms3/secondnumber";								
			int number2 = restTemplate.getForObject(url2, Integer.class);
//		
			HttpHeaders headers = new HttpHeaders();
			headers.set("Host", "ms1");
			headers.set("Host", "ms2");
			HttpEntity entity = new HttpEntity(headers);
			ResponseEntity<Integer> response = restTemplate.exchange(url2, HttpMethod.GET, entity, Integer.class,"" );
			int number1 = response.getBody();
//		int number1 = 5;
//		int number2 = 4;
				
		return number1+number2;
		//return 5;
		
		
	}
	
}
