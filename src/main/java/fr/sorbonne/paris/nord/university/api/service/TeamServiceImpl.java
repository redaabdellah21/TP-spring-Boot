package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.Factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.annotations.Loggable;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl  implements TeamService{

    private final TeamRepository teamrepository;
    private final TeamFactory teamFactory;

    @Autowired
    public TeamServiceImpl(TeamRepository teamrepository,TeamFactory teamFactory) {
        this.teamrepository = teamrepository;
        this.teamFactory = teamFactory;
    }

    @Override
    @Loggable
    @Transactional( readOnly = true )
    public List<TeamDTO> getAllTeams() {
        return teamrepository.findAll()
                .stream()
                .map(teamFactory::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Loggable
    @Transactional( readOnly = true )
    public Optional<TeamDTO> getTeamById(Long teamId) {
        return teamrepository.findById(teamId)
                .map(teamFactory::toDTO);
    }

    @Transactional
    @Override
    @Loggable
    public void addTeam(TeamDTO team) {
        teamrepository.save(teamFactory.toTeam(team));
    }

    @Transactional
    @Override
    @Loggable
    public void updateTeam(TeamDTO team) {
        final Team entity = teamrepository.findById(team.getId())
                .orElseThrow(IllegalStateException::new);
        entity.setName(team.getName());
        entity.setSlogan(team.getSlogan());
    }

    @Transactional
    @Override
    @Loggable
    public void deleteTeamById(Long id)
    {
        teamrepository.deleteById(id);
    }
}
