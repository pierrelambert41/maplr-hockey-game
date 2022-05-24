package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
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
    public Player changeCaptainRoleOnPlayer(Long id) throws Exception {
        Player player = playerRepository.getById(id);
        if (player != null) {
            this.removeCaptainRoleOnPlayer(player.getTeam());
            player.setCaptain(true);
            playerRepository.save(player);
            return player;
        }

        throw new Exception("Aucun joueur n'a été trouvé");
    }

    private void removeCaptainRoleOnPlayer(Team team) {
        team.getPlayers()
                .stream().
                filter(Player::isCaptain)
                .forEach(player -> {
                    player.setCaptain(false);
                    playerRepository.save(player);
        });
    }
}
