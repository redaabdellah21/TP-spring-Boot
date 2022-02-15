package fr.sorbonne.paris.nord.university.api.controller;


import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.service.PlayerService;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;



    @GetMapping("/all")
    public List<PlayerDTO> getAllTeams(){

        return playerService.getAllPlayers();
    }


}