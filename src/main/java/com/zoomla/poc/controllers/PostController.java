package com.zoomla.poc.controllers;

import com.zoomla.poc.entities.Post;
import com.zoomla.poc.respositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post show(@PathVariable Long id){
        return postRepository.findById(id)
                .orElseGet(Post::new);
    }
}
