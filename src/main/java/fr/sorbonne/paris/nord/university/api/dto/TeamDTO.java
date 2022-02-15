package fr.sorbonne.paris.nord.university.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.sorbonne.paris.nord.university.api.entity.Player;
import fr.sorbonne.paris.nord.university.api.entity.Sport;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
	public class TeamDTO {
		
		private long id;
		@NotEmpty
		private String name;
		@NotEmpty
		private String slogan;

		@JsonInclude(JsonInclude.Include.NON_NULL)
	    private List<PlayerDTO> players;
		@JsonInclude(JsonInclude.Include.NON_EMPTY)
		private Sport sport;


}


