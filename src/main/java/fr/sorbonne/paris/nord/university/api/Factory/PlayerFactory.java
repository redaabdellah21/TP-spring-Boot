package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.entity.Player;


public interface PlayerFactory {

    public Player toPlayer(PlayerDTO dto);
    PlayerDTO toDTO(Player entity);
}
