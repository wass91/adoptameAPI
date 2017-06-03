package com.adoptame.services;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Post;

public interface PostService {
	
	public Page<Post> getAll(Integer page, Integer limit) throws Exception;
	
	public Post create(Date date, boolean active, String observations, Integer visits, Integer userId, Integer petId) throws Exception;
	
	public Post update(Integer id, Date date, boolean active, String observations, Integer visits, Integer userId, Integer petId) throws Exception;
	
	public Post getById(Integer id) throws Exception;
	
	public Page<Post> getBySpecie(Integer specieId,Integer page, Integer limit) throws Exception;
	
	public Page<Post> getByBreed(Integer beedId,Integer page, Integer limit) throws Exception;
	
	public Post getByPet(Integer petId,Integer page, Integer limit) throws Exception;

	public Page<Post> getByUser(Integer userId,Integer page, Integer limit) throws Exception;
	
	public Page<Post> getByActive(boolean active,Integer page, Integer limit) throws Exception;
	
	public Integer addVisit(Integer id) throws Exception;
	
	public boolean activatePost(Integer id, boolean active) throws Exception;
	
	
}
