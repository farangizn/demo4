package com.example.demo4.entity;

import com.example.demo4.repo.BaseRepo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "groups")
public class Group extends BaseEntity {
    private String name;

//    @Builder
//    public Group(UUID id, LocalDateTime createdAt, String name) {
//        super(id, createdAt);
//        this.name = name;
//    }
}
