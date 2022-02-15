package fr.sorbonne.paris.nord.university.api.dto;

import fr.sorbonne.paris.nord.university.api.entity.Team;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class SportDTO {

    private long id;
    @NotEmpty
    private String name;
    private List<TeamDTO> teams;




}

