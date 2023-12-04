package com.simpleblog.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "comment")
public class CommentController {
    CommentService commentaryService;
    public CommentController(@Autowired CommentService commentaryService) {
        this.commentaryService = commentaryService;
    }

    @GetMapping(path = "findAll")
    public ResponseEntity<List<CommentEntity>> listAll() {
        return new ResponseEntity<List<CommentEntity>>(commentaryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentEntity> saveCommentary(@RequestBody CommentDTO commentaryDTO) {
        return new ResponseEntity<CommentEntity>(commentaryService.saveCommentary(commentaryDTO), HttpStatus.CREATED);
    }
}
