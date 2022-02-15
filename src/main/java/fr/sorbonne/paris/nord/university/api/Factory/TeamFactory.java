package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import org.springframework.stereotype.Component;

@Component
public interface TeamFactory {

    public Team toTeam(TeamDTO dto);
    TeamDTO toDTO(Team entity);
}
