package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    /**
     * Change Captain role of Player object
     * @param id
     * @return The player object
     */
    @PutMapping("/captain/{id}")
    public ResponseEntity<Player> changeCaptainRoleOnPlayer(@PathVariable Long id) throws Exception {
        Player result = playerService.changeCaptainRoleOnPlayer(id);
        return ResponseEntity.ok(result);
    }
}
