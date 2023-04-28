package com.psuti.Server.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Column(name = "name", nullable = false)
    private String name;
}
