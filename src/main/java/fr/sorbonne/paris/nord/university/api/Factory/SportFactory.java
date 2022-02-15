package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.dto.SportDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Sport;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import org.springframework.stereotype.Component;


@Component
public interface SportFactory {

    Sport toSport(SportDTO dto);

    SportDTO toSportDTO(Sport entity);



}
