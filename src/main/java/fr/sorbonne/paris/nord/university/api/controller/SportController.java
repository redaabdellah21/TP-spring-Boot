package fr.sorbonne.paris.nord.university.api.controller;


import fr.sorbonne.paris.nord.university.api.dto.SportDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.service.SportService;
import fr.sorbonne.paris.nord.university.api.service.TeamService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SportDTO>> getAllSports(){

        return ResponseEntity.ok(sportService.getAllSports());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SportDTO> getSportById(@PathVariable Long id){
        return ResponseEntity.of(sportService.getSportById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SportDTO> addSport(SportDTO sport) {
        try {
            sportService.addSport(sport);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<SportDTO> updateSport(@RequestBody @Validated SportDTO sport) {
        try{
            sportService.updateSport(sport);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeamDTO> delete(@PathVariable Long id) {

        sportService.deleteSportById(id);
        return ResponseEntity.ok().build();
    }

}
