package com.adoptame.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adoptame.services.PostService;
import com.adoptame.services.entities.Pet;
import com.adoptame.services.entities.Post;
import com.adoptame.services.entities.User;
import com.adoptame.services.repositories.PetRepository;
import com.adoptame.services.repositories.PostRepository;
import com.adoptame.services.repositories.UserRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Post> getAll(Integer page, Integer limit) throws Exception {
		Page<Post> pagePosts = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePosts = postRepository.findAll(pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePosts;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Post create(Date date, boolean active, String observations, Integer visits, Integer userId, Integer petId)
			throws Exception {
		Post post = null;
		try {
			post = new Post();
			User user = userRepository.findOne(userId);
			Pet pet = petRepository.findOne(petId);
			post.setDate(date);
			post.setActive(active);
			post.setObservations(observations);
			post.setVisits(visits);
			post.setUser(user);
			post.setPet(pet);
			post = postRepository.saveAndFlush(post);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return post;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Post update(Integer id, Date date, boolean active, String observations, Integer visits, Integer userId,
			Integer petId) throws Exception {
		Post post = null;
		try {
			post = postRepository.findOne(id);
			if(post == null){
				throw new Exception("Not post found");
			}
			User user = userRepository.findOne(userId);
			Pet pet = petRepository.findOne(petId);
			post.setDate(date);
			post.setActive(active);
			post.setObservations(observations);
			post.setVisits(visits);
			post.setUser(user);
			post.setPet(pet);
			post = postRepository.saveAndFlush(post);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return post;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Post getById(Integer id) throws Exception {
		Post post = null;
		try {
			post = postRepository.findOne(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return post;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Post> getBySpecie(Integer specieId, Integer page, Integer limit) throws Exception {
		Page<Post> pagePosts = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePosts = postRepository.findBySpecieId(specieId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePosts;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Post> getByBreed(Integer breedId, Integer page, Integer limit) throws Exception {
		Page<Post> pagePosts = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePosts = postRepository.findByBreedId(breedId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePosts;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Post getByPet(Integer petId, Integer page, Integer limit) throws Exception {
		Post post = null;
		
		try {
			post = postRepository.findByPetId(petId);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return post;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Post> getByUser(Integer userId, Integer page, Integer limit) throws Exception {
		Page<Post> pagePosts = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePosts = postRepository.findByUserId(userId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePosts;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Post> getByActive(boolean active, Integer page, Integer limit) throws Exception {
		Page<Post> pagePosts = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePosts = postRepository.findByActive(true, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePosts;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Integer addVisit(Integer id) throws Exception {
		Post post = null;
		try {
			post = postRepository.findOne(id);
			if(post == null){
				throw new Exception("Not post found");
			}
			post.setVisits(post.getVisits()+1);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return post.getVisits();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public boolean activatePost(Integer id, boolean active) throws Exception {
		Post post = null;
		try {
			post = postRepository.findOne(id);
			if(post == null){
				throw new Exception("Not post found");
			}
			post.setActive(active);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return post.getActive();
	}

}