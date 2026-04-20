package com.football.proyectMarker.service;

import com.football.proyectMarker.dto.request.PlayerRequestDTO;
import com.football.proyectMarker.dto.response.PlayerResponseDTO;

import java.util.List;

public interface PlayerService {

    List<PlayerResponseDTO> findAllByTeamId(Long teamId);

    List<PlayerResponseDTO> createPlayers(List<PlayerRequestDTO> playerRequestDTOS);

    PlayerResponseDTO updatePlayer(Long id, PlayerRequestDTO playerRequestDTO);

    void deleteById(Long id);


}
