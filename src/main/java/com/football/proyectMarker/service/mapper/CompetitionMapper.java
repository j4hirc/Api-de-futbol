package com.football.proyectMarker.service.mapper;

import com.football.proyectMarker.dto.request.CompetitionRequestDTO;
import com.football.proyectMarker.dto.response.CompetitionResponseDTO;
import com.football.proyectMarker.model.Competition;
import com.football.proyectMarker.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CompetitionMapper {

    public CompetitionResponseDTO toResponse(Competition competition){
        CompetitionResponseDTO competitionResponseDTO = new CompetitionResponseDTO();
        competitionResponseDTO.setName(competition.getName());
        competitionResponseDTO.setCountryName(competition.getCountry().getName());
        return  competitionResponseDTO;
    }

    public Competition toEntity(Country country, CompetitionRequestDTO competitionRequestDTO){
        Competition competition = new Competition();
        competition.setName(competitionRequestDTO.getName());
        competition.setCountry(country);
        return competition;
    }

}
