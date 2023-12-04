package com.simpleblog.comment;

import lombok.Data;

@Data
public class CommentDTO {
    private String text;
    private Long postId;
}