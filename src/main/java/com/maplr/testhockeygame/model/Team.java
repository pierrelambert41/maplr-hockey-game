package com.maplr.testhockeygame.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String coach;
    private long year;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Player> players;

    public Team() {}

    public Team(String coach, long year, List<Player> players) {
        this.coach = coach;
        this.year = year;
        this.players = players;
    }
}
