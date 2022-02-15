package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.Factory.SportFactory;
import fr.sorbonne.paris.nord.university.api.annotations.Loggable;
import fr.sorbonne.paris.nord.university.api.dto.SportDTO;
import fr.sorbonne.paris.nord.university.api.entity.Sport;
import fr.sorbonne.paris.nord.university.api.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportServicImpl implements SportService {

    private final SportRepository sportrepository;
    private final SportFactory sportFactory;

    @Autowired
    public SportServicImpl(SportRepository sportrepository, SportFactory sportFactory) {
        this.sportrepository = sportrepository;
        this.sportFactory = sportFactory;
    }

    @Override
    public List<SportDTO> getAllSports() {
        return sportrepository.findAll()
                .stream()
                .map(sportFactory::toSportDTO)
                .collect(Collectors.toList());
    }

    @Transactional( readOnly = true )
    @Override
    public Optional<SportDTO> getSportById(Long sportId) {
        return sportrepository.findById(sportId)
                              .map(sportFactory::toSportDTO);
    }
    @Override
    @Transactional
    public void addSport(SportDTO sportDTO) {
        sportrepository.save(sportFactory
                       .toSport(sportDTO));

    }

    @Override
    @Transactional
    public void updateSport(SportDTO sport) {
        final Sport entity = sportrepository.findById(sport.getId())
                                            .orElseThrow(IllegalStateException::new);

        entity.setName(sport.getName());

    }

    @Override
    @Transactional
    public void deleteSportById(Long id) {
        sportrepository.deleteById(id);

    }
}
