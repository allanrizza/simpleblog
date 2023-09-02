package com.simpleblog.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    @NonNull
    private String body;

    @Column(name = "createdAt", nullable = false)
    @NonNull
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
}
