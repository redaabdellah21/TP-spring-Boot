package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.SportDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Sport;

import java.util.List;
import java.util.Optional;

public interface SportService {


    List<SportDTO> getAllSports();
    Optional<SportDTO> getSportById(Long sportId);
    void addSport (SportDTO sport);
    void updateSport (SportDTO sport);
    void deleteSportById (Long id);
}
