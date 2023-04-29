package com.psuti.Server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "events")
public class Events implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false,name = "date")
    private Date date;

    @Column(nullable = false,name = "time")
    private Time time;

    @Column(nullable = false, length = 25, name = "maximum")
    private int maximum;

    @ManyToOne(targetEntity = Address.class)
    @JoinColumn(name = "address")
    private Address address;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "users")
    private User users;

    @ManyToOne (targetEntity = Category.class)
    @JoinColumn(name = "category")
    private Category category;
}
