package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.Factory.PlayerFactory;
import fr.sorbonne.paris.nord.university.api.entity.Player;
import fr.sorbonne.paris.nord.university.api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.entity.Player;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerFactory playerFactory;
    @Autowired
    private PlayerRepository playerRepository;


    @Override
    @Transactional
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(playerFactory::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<Player> getPlayerById(Long playerId) {
        return Optional.empty();
    }
}
