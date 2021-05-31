package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;


    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player changeCaptainRoleOnPlayer(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(null);
        if (player.isCaptain()) {
            player.setCaptain(false);
        } else {
            player.setCaptain(true);
        }
        playerRepository.save(player);
        return player;
    }
}
