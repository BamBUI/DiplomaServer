package com.psuti.Server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="Category")
public class Category {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

}
