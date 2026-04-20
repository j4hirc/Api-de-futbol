package com.football.proyectMarker.service.mapper;

import com.football.proyectMarker.dto.response.TeamResponseDTO;
import com.football.proyectMarker.dto.request.TeamResquestDTO;
import com.football.proyectMarker.model.Country;
import com.football.proyectMarker.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public TeamResponseDTO toResponseDTO(Team team){
        TeamResponseDTO responseDTO = new TeamResponseDTO();
        responseDTO.setName(team.getName());
        responseDTO.setNameCountry(team.getName());
        responseDTO.setStadium(team.getStadium());
        return responseDTO;
    }

    public Team ToEntity(Country country, TeamResquestDTO teamResquestDTO){
        Team team = new Team();
        team.setName(teamResquestDTO.getName());
        team.setCountry(country);
        team.setStadium(teamResquestDTO.getStadium());

        return team;
    }


}
