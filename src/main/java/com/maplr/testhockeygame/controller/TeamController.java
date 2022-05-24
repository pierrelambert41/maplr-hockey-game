package com.maplr.testhockeygame.controller;


import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.service.TeamService;
import com.maplr.testhockeygame.model.Team;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * Read - Get Teams by year
     * @param year
     * @return An object of Team full filled
     */
    @GetMapping("/{year}")
    public ResponseEntity<Team> getTeamByYear(@PathVariable Long year) {
        Team result = teamService.getTeamByYear(year);
        try {
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Add Player into Team by Year
     * @param year
     * @param player
     * @return The player object saved
     */
    @PostMapping("/{year}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Player> addPlayerIntoTeamByYear(@PathVariable Long year, @RequestBody Player player) {
        teamService.addPlayerIntoTeamByYear(year, player);
        return  ResponseEntity.status(HttpStatus.CREATED).body(player);
    }
}
