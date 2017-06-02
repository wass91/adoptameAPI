package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
}
