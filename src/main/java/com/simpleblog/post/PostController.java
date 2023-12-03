package com.simpleblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "post")
public class PostController {
    PostService postService;
    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "findAll")
    public List<PostEntity> findAll() {
        return postService.findAll();
    }

    @GetMapping(path = "findById")
    public Optional<PostEntity> findById(@RequestParam Long id) {
        return postService.findById(id);
    }
}
