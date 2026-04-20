package com.football.proyectMarker.service;

import com.football.proyectMarker.dto.request.CompetitionRequestDTO;
import com.football.proyectMarker.dto.response.CompetitionResponseDTO;

import java.util.List;

public interface CompetitionService {

    List<CompetitionResponseDTO> findAll();

    CompetitionResponseDTO findByNameCountry(String nameCountry);

    List<CompetitionResponseDTO> createCompetition(List<CompetitionRequestDTO> competitionRequestDTOS);

    CompetitionResponseDTO updateCompetition(Long id, CompetitionRequestDTO competitionRequestDTO);

    void deleteById(Long id);


}
