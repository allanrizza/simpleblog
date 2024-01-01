package com.simpleblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleblog.post.exception.PostNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;
    public PostService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity findById(Long id) {
        Optional<PostEntity> post = postRepository.findById(id);

        if(!post.isPresent())
            throw new PostNotFoundException(id);
        
        return post.get();
    }

    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

    public PostEntity savePost(PostDTO postDTO) {
        PostEntity post = new PostEntity();
        post.setTitle(postDTO.getTitle());
        post.setBody(postDTO.getBody());
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }
}
