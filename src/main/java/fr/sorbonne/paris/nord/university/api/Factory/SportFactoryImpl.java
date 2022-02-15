package fr.sorbonne.paris.nord.university.api.Factory;

import fr.sorbonne.paris.nord.university.api.dto.SportDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SportFactoryImpl implements SportFactory{


    @Override
    public Sport toSport(SportDTO dto) {
        final Sport sportEntity = new Sport();
        sportEntity.setId(dto.getId());
        sportEntity.setName(dto.getName());


        return sportEntity;
    }

    @Override
    public SportDTO toSportDTO(Sport entity) {
        final SportDTO sportDTO = new SportDTO();
        sportDTO.setId(entity.getId());
        sportDTO.setName(entity.getName());

        return sportDTO;
    }

}
