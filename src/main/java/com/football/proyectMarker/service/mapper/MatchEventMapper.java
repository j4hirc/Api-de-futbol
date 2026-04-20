package com.football.proyectMarker.service.mapper;

import com.football.proyectMarker.dto.request.MatchEventRequestDTO;
import com.football.proyectMarker.dto.response.MatchEventResponseDTO;
import com.football.proyectMarker.model.Match;
import com.football.proyectMarker.model.MatchEvent;
import org.springframework.stereotype.Component;

@Component
public class MatchEventMapper {

    public MatchEventResponseDTO toResponse(MatchEvent matchEvent){
        MatchEventResponseDTO matchEventResponseDTO = new MatchEventResponseDTO();
        matchEventResponseDTO.setEvent(matchEvent.getEvent());
        matchEventResponseDTO.setMatchMinute(matchEvent.getMatchMinute());
        matchEventResponseDTO.setDescription(matchEvent.getDescription());
        return matchEventResponseDTO;
    }

    public MatchEvent toEntity(Match match, MatchEventRequestDTO matchEventRequestDTO){
        MatchEvent matchEvent = new MatchEvent();
        matchEvent.setDescription(matchEventRequestDTO.getDescription());
        matchEvent.setMatch(match);
        matchEvent.setMatchMinute(matchEventRequestDTO.getMatchMinute());
        matchEvent.setEvent(matchEventRequestDTO.getEvent());

        return matchEvent;
    }


}
