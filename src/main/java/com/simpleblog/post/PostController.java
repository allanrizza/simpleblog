package com.simpleblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<PostEntity> findById(@RequestParam Long id) {
        return new ResponseEntity<PostEntity>(postService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostEntity> savePost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<PostEntity>(postService.savePost(postDTO), HttpStatus.CREATED);
    }
}
