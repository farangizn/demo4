package com.example.demo4.entity;

import com.example.demo4.repo.BaseRepo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "roles")
public class Role extends BaseEntity {
    private String name;
}
