package com.simpleblog.comment;

import java.time.LocalDateTime;
import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleblog.post.PostEntity;
import com.simpleblog.post.PostRepository;

@Service
public class CommentService {
    CommentRepository commentaryRepository;
    PostRepository postRepository;
    public CommentService(@Autowired CommentRepository commentaryRepository,
                             @Autowired PostRepository postRepository
    ) {
        this.commentaryRepository = commentaryRepository;
        this.postRepository = postRepository;
    }

    public List<CommentEntity> findAll() {
        return commentaryRepository.findAll();
    }

    public CommentEntity saveCommentary(CommentDTO commentaryDTO) {
        CommentEntity commentary = new CommentEntity();
        Optional<PostEntity> post = postRepository.findById(commentaryDTO.getPostId());
        if(post.isEmpty()){
            throw new IllegalArgumentException("Não foi possível identificar o post para este comentário.");
        }
        commentary.setPost(post.get());
        commentary.setText(commentaryDTO.getText());
        commentary.setCreatedAt(LocalDateTime.now());
        return commentaryRepository.save(commentary);
    }
    
}
