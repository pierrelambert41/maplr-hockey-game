package com.maplr.testhockeygame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long number;
    private String name;
    private String lastname;
    private String position;
    private boolean isCaptain;

    @ManyToOne
    private Team team;

    public Player() {}

    public Player(long number, String name, String lastname, String position, boolean isCaptain) {
        this.number = number;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.isCaptain = isCaptain;
    }

    @JsonIgnore
    public Long getId() { return id; }

    @JsonIgnore
    public Team getTeam() { return team;}
}
