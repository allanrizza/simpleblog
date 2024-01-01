package com.simpleblog.post;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.simpleblog.post.exception.PostNotFoundException;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @InjectMocks
    PostService postService;

    @Mock
    PostRepository postRepository;

    PostEntity post;

    @BeforeEach
    public void setUp() {
        post = new PostEntity();
        post.setId(1L);
        post.setTitle("Título post 1 teste");
        post.setBody("Body teste post 1");
        post.setCreatedAt(LocalDateTime.now());
    }
    
    @Test
    void shouldSuccessfullySearchForPostById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        PostEntity postTest = postService.findById(1L);
        assertEquals(post, postTest);
    }

    @Test
    void findById_WhenPostDoesNotExist_ShouldThrowRuntimeException() {
        when(postRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(PostNotFoundException.class, () -> {
            postService.findById(2L);
        }, "Post with id 2 does not exist.");
    }
}
