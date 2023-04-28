package com.psuti.Server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false, length = 255,name = "name")
    private String name;

    @Column(nullable = false, length = 25, name = "x_coordinate")
    private String x_coordinate;

    @Column(nullable = false, length = 25, name = "y_coordinate")
    private String y_coordinate;

    @Column(nullable = false, length = 25, name = "city")
    private String city;
}
