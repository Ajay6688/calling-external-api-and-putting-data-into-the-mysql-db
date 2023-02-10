package com.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcrud.service.CallApiService;


@RestController
@RequestMapping("/api")
public class CallExternalApi {
	
	private CallApiService callApiService ;
	
	@Autowired
	public CallExternalApi(CallApiService callApiService) {
		this.callApiService = callApiService;
	}

	
	@GetMapping("/hello")
	public String hello() {
		return "hello from spring boot";
	}
	
	@GetMapping("/callApi")
	public ResponseEntity<String> callApiAndPutDataInDb() {
		
		
		try {
			
			final String url  = "https://datausa.io/api/data?drilldowns=Nation&measures=Population";
			
			RestTemplate restTemplate = new RestTemplate();
			
			String data = restTemplate.getForObject(url, String.class);
			
//			System.out.println(data);
			callApiService.addDataIntoDb(data);
			
	
			return new ResponseEntity<String>("Data added to the DB successfully", HttpStatus.OK);
			
		} catch (Exception e) { 
		    System.out.println(e);
		    return new ResponseEntity<String>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
