package com.ekiasari.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekiasari.joblisting.PostRepository;
import com.ekiasari.joblisting.model.Post;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PostController {

  @Autowired
  PostRepository repo;

  @GetMapping("/posts")
  public List<Post> getAllPosts() {
    return repo.findAll();
  }

  @PostMapping("/postMethodName")
  public Post addPost(@RequestBody Post post) {
    return repo.save(post);
  }

}
