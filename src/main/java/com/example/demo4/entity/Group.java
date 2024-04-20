package com.example.demo4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Table(name = "groups")
public class Group extends BaseEntity {
    private String name;

}
