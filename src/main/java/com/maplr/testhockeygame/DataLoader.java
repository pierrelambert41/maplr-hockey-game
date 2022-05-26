package com.maplr.testhockeygame;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataLoader {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public DataLoader(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Bean
    public CommandLineRunner buildTeams(TeamRepository teamRepository) {
        return args ->
                teamRepository.saveAll(Arrays.asList(
                        new Team("Dominique Ducharme", 2019, Collections.emptyList()),
                        new Team("Dominique Ducharme", 2020, Collections.emptyList())
                )).forEach(this::buildPlayersList);
    }

    private List<Player> buildPlayersList(Team team) {
        return playerRepository.saveAll(Stream.of(
                new Player(31, "Carey", "Price", "goaltender", false),
                new Player(14, "Nick", "Suzuki", "foward", false),
                new Player(15, "Jesperi", "Kotkaniemi", "foward", true),
                new Player(71, "Jake", "Evans", "foward", false),
                new Player(27, "Alexander", "Romanov", "defenseman", false),
                new Player(6, "Shea", "Weber", "defenseman", false)
        ).peek(player -> player.setTeam(team)).collect(Collectors.toList()));
    }
}
