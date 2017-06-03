package com.adoptame.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adoptame.services.BaseController;
import com.adoptame.services.PostService;
import com.adoptame.services.ServiceDirectory;
import com.adoptame.services.entities.Post;
import com.adoptame.services.json.Response;

@RestController
public class PostController extends BaseController{
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = ServiceDirectory.POST_GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAll(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Post> posts = null;
		try {
			posts = postService.getAll(--page, limit);
			response = this.createResponse(posts.getContent());
			Long total = posts.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam String date, @RequestParam boolean active, @RequestParam String observations, 
			@RequestParam Integer visits,@RequestParam Integer userId,@RequestParam Integer petId){
		Response response = null;
		Post post = null;
		try {
			post = postService.create(formatter.parse(date), active, observations, 0, userId, petId);
			response = this.createResponse(post);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_UPDATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response update(@RequestParam Integer postId, @RequestParam String date, @RequestParam boolean active, @RequestParam String observations, 
			@RequestParam Integer visits,@RequestParam Integer userId,@RequestParam Integer petId){
		Response response = null;
		Post post = null;
		try {
			post = postService.update(postId,formatter.parse(date), active, observations, visits, userId, petId);
			response = this.createResponse(post);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getById(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(postService.getById(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_GET_ACTIVE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getActive(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Post> posts = null;
		try {
			posts = postService.getByActive(true, --page, limit);
			response = this.createResponse(posts.getContent());
			Long total = posts.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_ACTIVATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response activatePost(@RequestParam Integer id, @RequestParam boolean active){
		Response response = null;
		try {
			response = createResponse(postService.activatePost(id, active));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_GET_BY_PET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByPet(@RequestParam Integer petId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		try {
			response = createResponse(postService.getByPet(petId, --page, limit));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_GET_BY_SPECIE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getBySpecie(@RequestParam Integer specieId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Post> posts = null;
		try {
			posts = postService.getBySpecie(specieId, --page, limit);
			response = this.createResponse(posts.getContent());
			Long total = posts.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_GET_BY_BREED, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByBreed(@RequestParam Integer breedId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Post> posts = null;
		try {
			posts = postService.getByBreed(breedId, --page, limit);
			response = this.createResponse(posts.getContent());
			Long total = posts.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_GET_BY_USER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByUser(@RequestParam Integer userId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Post> posts = null;
		try {
			posts = postService.getByUser(userId, --page, limit);
			response = this.createResponse(posts.getContent());
			Long total = posts.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POST_ADD_VISIT, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response activatePost(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(postService.addVisit(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
}
