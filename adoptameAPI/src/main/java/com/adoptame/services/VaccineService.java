package com.adoptame.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Vaccine;

public interface VaccineService {
	
	public Page<Vaccine> getAll(Integer page, Integer limit) throws Exception;
	
	public Vaccine create(String name) throws Exception;
	
	public Vaccine update(Integer id, String name) throws Exception;
	
	public Vaccine getById(Integer id) throws Exception;
}
