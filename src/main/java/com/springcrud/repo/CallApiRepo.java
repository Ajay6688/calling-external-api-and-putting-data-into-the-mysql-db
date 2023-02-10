package com.springcrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcrud.entity.UsaPopulation;

public interface CallApiRepo extends JpaRepository<UsaPopulation, String>{
	
};
