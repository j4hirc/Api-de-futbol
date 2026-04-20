package com.football.proyectMarker.service.mapper;

import com.football.proyectMarker.dto.request.MatchRequestDTO;
import com.football.proyectMarker.dto.response.MatchResponseDTO;
import com.football.proyectMarker.model.Competition;
import com.football.proyectMarker.model.Match;
import com.football.proyectMarker.model.Team;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

public MatchResponseDTO toResponseDTO(Match match){

    MatchResponseDTO responseDTO = new MatchResponseDTO();
    responseDTO.setHomeTeamName(match.getHomeTeam().getName());
    responseDTO.setAwayTeamName(match.getAwayTeam().getName());
    responseDTO.setCompetitionName(match.getCompetition().getName());
    responseDTO.setDateMatch(match.getDateMatch());
    responseDTO.setStatus(match.getStatus().toUpperCase());
    responseDTO.setLocalScore(match.getLocalScore());
    responseDTO.setAwayScoreboard(match.getAwayScoreboard());
    return responseDTO;

}

public Match toEntity(Team homeTeam, Team awayTeam, Competition competition, MatchRequestDTO requestDTO){
    Match match = new Match();
    match.setHomeTeam(homeTeam);
    match.setAwayTeam(awayTeam);
    match.setDateMatch(requestDTO.getDateMatch());
    match.setStatus(requestDTO.getStatus());
    match.setCompetition(competition);
    match.setLocalScore(requestDTO.getLocalScore());
    match.setAwayScoreboard(requestDTO.getAwayScoreboard());
    return match;
}


}
