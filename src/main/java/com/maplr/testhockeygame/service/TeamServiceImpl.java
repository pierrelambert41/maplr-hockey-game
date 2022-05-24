package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team getTeamByYear(Long year) {
        return teamRepository.findByYear(year);
    }

    @Override
    public Team addPlayerIntoTeamByYear(Long year, Player player) {
        Team team = getTeamByYear(year);
        player.setTeam(team);
        team.getPlayers().add(player);
        return teamRepository.save(team);
    }
}
