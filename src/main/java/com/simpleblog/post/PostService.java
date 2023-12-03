package com.simpleblog.post;

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

    public Optional<PostEntity> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

}
