package fr.sorbonne.paris.nord.university.api;

import fr.sorbonne.paris.nord.university.api.Factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import fr.sorbonne.paris.nord.university.api.service.TeamServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TeamServiceTest {

    private TeamRepository teamrepository;
    private TeamFactory teamFactory;
    private TeamServiceImpl service;

    @Test
    void getAllTeams() {
        // GIVEN
        final ArrayList<Team> teamEntities = new ArrayList<>();
        teamEntities.add(new Team());

        when(teamrepository.findAll()).thenReturn(teamEntities);
        doCallRealMethod().when(teamFactory).toDTO(any());

        //when
        final List<TeamDTO> allTeams =service.getAllTeams();

        //then
        assertEquals(1 , allTeams.size());
        verify(teamrepository, times(1)).findAll();
    }

    @Test
    void getTeamById() {

        //GIVEN
        final Team entity = new Team();
        entity.setId(123456L);
        entity.setName("NAME");
        entity.setSlogan("SLOGAN");

        when(teamrepository.findById(anyLong())).thenReturn(Optional.of(entity));

        doCallRealMethod().when(teamFactory).toDTO(any(Team.class));

        //WHEN
        final Optional<TeamDTO> dto = service.getTeamById(123456L);

        //THEN
        assertTrue(dto.isPresent());
        assertEquals(123456L, dto.get().getId());

        verify(teamrepository).findById(123456L);
        verify(teamFactory).toDTO(entity);

    }

    @Test
    void addTeam(TeamDTO team) {
        //GIVEN
        final TeamDTO teamDTO = new TeamDTO();
        final  Team entity = new Team();
        when(teamFactory.toTeam(any())).thenReturn(entity);
        when(teamrepository.save(any(Team.class))).thenAnswer(i -> i.getArguments());

        //WHEN
        service.addTeam(teamDTO);

        //THEN
        verify(teamFactory).toTeam(teamDTO);
        verify(teamrepository).save(entity);
    }

    @Test
    void updateTeam(TeamDTO team) {
        //GIVEN
        final TeamDTO  teamDTO = new TeamDTO();
        teamDTO.setId(1L);
        teamDTO.setName("NAME");
        teamDTO.setSlogan("SLOGAN");

        final Team entity = new Team();
        entity.setName("XXXX");

        when(teamrepository.findById(anyLong())).thenReturn(Optional.of(entity));

        //WHEN
        service.updateTeam(teamDTO);

        //THEN
        assertEquals("NAME", entity.getName());
        assertEquals("SLOGAN", entity.getSlogan());

        verify(teamrepository).findById(1L);
    }

    @Test
    void deleteTeamById () {
        //GIVEN
        doNothing().when(teamrepository).deleteById(anyLong());

        //WHEN
        service.deleteTeamById(1L);

        //THEN
        verify(teamrepository, times(1)).deleteById(1L);
    }
}