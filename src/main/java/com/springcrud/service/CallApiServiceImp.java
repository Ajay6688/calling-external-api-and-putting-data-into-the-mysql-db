package com.springcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcrud.entity.UsaPopulation;
import com.springcrud.repo.CallApiRepo;

@Service
public class CallApiServiceImp implements CallApiService {
	 
	
	private CallApiRepo callApiRepo ;
	
	private final ObjectMapper objectMapper;
	
	@Autowired
	public CallApiServiceImp(CallApiRepo callApiRepo,ObjectMapper objectMapper) {
		
		this.callApiRepo =callApiRepo;
		this.objectMapper = objectMapper;
	}

	public void addDataIntoDb(String jsonData) {
		System.out.println("inside service");
		try {
		    JsonNode root = objectMapper.readTree(jsonData);
		    JsonNode dataNode = root.path("data");
		    System.out.println(dataNode);
		    List<UsaPopulation> usaPopulation = new ArrayList<>();
		    usaPopulation =  objectMapper.readValue(dataNode.toString(), new TypeReference<List<UsaPopulation>>(){});
		    System.out.println(usaPopulation.getClass());
//		    for (UsaPopulation u : usaPopulation) {
//		    	System.out.println(u.getIdNation()+u.getNation()+u.getIdYear()+u.getPopulation());
//			}
		    callApiRepo.saveAll(usaPopulation);
		    
		} catch (JsonProcessingException e) {
		    e.printStackTrace();
		}
	}

}
