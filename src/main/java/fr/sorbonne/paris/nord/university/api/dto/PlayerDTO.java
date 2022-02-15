package fr.sorbonne.paris.nord.university.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PlayerDTO {

    private long id ;
    @NotEmpty
    private String name;
    @Size(max=2)
    private String number;
    @Size(max=10)
    private String position;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TeamDTO teamdto;
}
