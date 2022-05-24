package com.maplr.testhockeygame;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader {

    private TeamRepository teamRepository;

    @Autowired
    public DataLoader(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Bean
    public CommandLineRunner buildTeams(TeamRepository teamRepository) {
        return args -> teamRepository.saveAll(Arrays.asList(
                new Team("Dominique Ducharme", 2019, buildPlayersList()),
                new Team("Dominique Ducharme", 2020, buildPlayersList())
        ));
    }

    private List<Player> buildPlayersList() {
        return Arrays.asList(
                new Player(31, "Carey", "Price", "goaltender", false),
                new Player(14, "Nick", "Suzuki", "foward", false),
                new Player(15, "Jesperi", "Kotkaniemi", "foward", true),
                new Player(71, "Jake", "Evans", "foward", false),
                new Player(27, "Alexander", "Romanov", "defenseman", false),
                new Player(6, "Shea", "Weber", "defenseman", false)
        );
    }
}
