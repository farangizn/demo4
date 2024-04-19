package com.example.demo4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Student extends BaseEntity {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    @ManyToOne
    private Group group;
    @ManyToMany
    private List<Role> roles;


//    @Builder
//    public User(UUID id, LocalDateTime createdAt, String email, String password) {
//        super(id, createdAt);
//        this.email = email;
//        this.password = password;
//    }
}
