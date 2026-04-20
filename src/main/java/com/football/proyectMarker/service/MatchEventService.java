package com.football.proyectMarker.service;

import com.football.proyectMarker.dto.request.MatchEventRequestDTO;
import com.football.proyectMarker.dto.response.MatchEventResponseDTO;

import java.util.List;

public interface MatchEventService {

    List<MatchEventResponseDTO> findByIdMatch(Long matchId);

    List<MatchEventResponseDTO> createMatchEvent(List<MatchEventRequestDTO> matchEventRequestDTO);

    MatchEventResponseDTO updateMatchEvent(Long matchEventId, MatchEventRequestDTO matchEventRequestDTO);

    void deleteById(Long id);



}
