package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;


public interface TeamService {

    Team getTeamByYear(Long year);
    Team addPlayerIntoTeamByYear(Long year, Player player);
}
