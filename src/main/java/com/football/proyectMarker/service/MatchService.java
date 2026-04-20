package com.football.proyectMarker.service;

import com.football.proyectMarker.dto.request.MatchRequestDTO;
import com.football.proyectMarker.dto.response.MatchResponseDTO;

import java.util.List;

public interface MatchService {

    List<MatchResponseDTO> findByNameTeam(String name);

    List<MatchResponseDTO> findAllMatches();

    List<MatchResponseDTO> createMatch(List<MatchRequestDTO> requestDTOs);

    MatchResponseDTO updateMatch(Long id, MatchRequestDTO matchRequestDTO);

    void deleteById(Long id);



}
