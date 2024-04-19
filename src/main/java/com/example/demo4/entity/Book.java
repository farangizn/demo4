package com.example.demo4.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {
    private String name;
    private String author;
//    @Builder
//    public Book(UUID id, LocalDateTime createdAt, String name, String author) {
//        super(id, createdAt);
//        this.name = name;
//        this.author = author;
//    }
}
