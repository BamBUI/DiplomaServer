package com.psuti.Server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "crowd")
public class Crowd implements Serializable {

    public Crowd(){}


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "events")
    private Events events;

    @OneToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<User> user;
}
