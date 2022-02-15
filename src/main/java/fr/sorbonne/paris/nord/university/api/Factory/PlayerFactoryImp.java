package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Player;
import fr.sorbonne.paris.nord.university.api.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerFactoryImp implements PlayerFactory{

    private TeamFactory teamFactory;

    @Autowired
    public PlayerFactoryImp(TeamFactory teamFactory) {
        this.teamFactory = teamFactory;
    }

    @Override
    public Player toPlayer(PlayerDTO dto) {
        final Player playerEntity = new Player();
        playerEntity.setId(dto.getId());
        playerEntity.setName(dto.getName());
        playerEntity.setPosition(dto.getPosition());
        playerEntity.setNumber(dto.getNumber());
       // Team team = teamFactory.toTeam(dto.getTeamdto());
        //playerEntity.setTeam(team);

        return playerEntity;
    }

    @Override
    public PlayerDTO toDTO(Player entity) {
        final PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(entity.getId());
        playerDTO.setName(entity.getName());
        playerDTO.setNumber(entity.getNumber());
        playerDTO.setPosition(entity.getPosition());
        //TeamDTO dto = teamFactory.toDTO(entity.getTeam());
       // playerDTO.setTeamdto(dto);

        return playerDTO;
    }
}
