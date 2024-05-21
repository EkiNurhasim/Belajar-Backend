package com.ekiasari.joblisting;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ekiasari.joblisting.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
