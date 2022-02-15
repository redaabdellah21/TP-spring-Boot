package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TeamService {

    List<TeamDTO> getAllTeams();
    Optional<TeamDTO> getTeamById(Long teamId);
    void addTeam (TeamDTO team);
    void updateTeam (TeamDTO team);
    void deleteTeamById (Long id);

}
