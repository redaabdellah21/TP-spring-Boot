package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.SportDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Player;
import fr.sorbonne.paris.nord.university.api.entity.Sport;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamFactoryImp implements TeamFactory{


    @Override
    public Team toTeam(TeamDTO dto) {
        final Team teamEntity = new Team();
        teamEntity.setId(dto.getId());
        teamEntity.setName(dto.getName());
        teamEntity.setSlogan(dto.getSlogan());
        teamEntity.setPalyers(new ArrayList<Player>());
        //Sport s =new Sport();
       // s.setName(dto.getSport().getName());
      //  teamEntity.setSport(s);
        return teamEntity;
    }

    @Override
    public TeamDTO toDTO(Team entity) {
        final TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(entity.getId());
        teamDTO.setName(entity.getName());
        teamDTO.setSlogan(entity.getSlogan());
        teamDTO.setPlayers(new ArrayList<PlayerDTO>());
        //SportDTO sdto =new SportDTO();
       // sdto.setName(entity.getSport().getName());
     //   teamDTO.setSport(sdto);
        return teamDTO;
    }



}
