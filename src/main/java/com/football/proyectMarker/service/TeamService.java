package com.football.proyectMarker.service;

import com.football.proyectMarker.dto.response.TeamResponseDTO;
import com.football.proyectMarker.dto.request.TeamResquestDTO;

import java.util.List;

public interface TeamService {

    List<TeamResponseDTO> findAll();

    List<TeamResponseDTO> findByCountry(Long countryId);

    TeamResponseDTO Save(TeamResquestDTO teamResquestDTO);

    TeamResponseDTO updateTeam(Long id, TeamResquestDTO teamResquestDTO);




}
