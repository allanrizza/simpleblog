package com.simpleblog.services;

import com.simpleblog.entities.Post;
import com.simpleblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;
    public PostService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

}
