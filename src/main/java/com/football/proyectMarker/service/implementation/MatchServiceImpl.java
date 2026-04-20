package com.football.proyectMarker.service.implementation;

import com.football.proyectMarker.dto.request.MatchRequestDTO;
import com.football.proyectMarker.dto.response.MatchResponseDTO;
import com.football.proyectMarker.exception.ResourceNotFoundException;
import com.football.proyectMarker.model.Competition;
import com.football.proyectMarker.model.Match;
import com.football.proyectMarker.model.Team;
import com.football.proyectMarker.repository.RepositoryCompetition;
import com.football.proyectMarker.repository.RepositoryMatch;
import com.football.proyectMarker.repository.RepositoryTeam;
import com.football.proyectMarker.service.MatchService;
import com.football.proyectMarker.service.mapper.MatchMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {

    private RepositoryMatch repositoryMatch;
    private RepositoryTeam repositoryTeam;
    private RepositoryCompetition repositoryCompetition;
    private MatchMapper matchMapper;


    @Override
    public List<MatchResponseDTO> findByNameTeam(String name) {
        List<Match> matches = repositoryMatch.findByNameTeam(name);

        if (matches.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron partidos de el equipo: " + name);
        }

        return matches.stream()
                .map(matchMapper::toResponseDTO)
                .toList();
    }


    @Override
    public List<MatchResponseDTO> findAllMatches() {
        List<Match> matches = repositoryMatch.findAllMatchesWithDetails();

        return matches.stream()
                .map(matchMapper::toResponseDTO)
                .toList();
    }


    @Override
    public List<MatchResponseDTO> createMatch(List<MatchRequestDTO> requestDTOs) {

        List<Match> matchesToSave = requestDTOs.stream()
                .map(dto -> {
                    Team homeTeam = repositoryTeam.getReferenceById(dto.getHomeTeamid());
                    Team awayTeam = repositoryTeam.getReferenceById(dto.getAwayTeamid());
                    Competition competition = repositoryCompetition.getReferenceById(dto.getCompetitionId());
                    return matchMapper.toEntity(homeTeam, awayTeam, competition, dto);
                }).toList();

        List<Match> savedMatches = repositoryMatch.saveAll(matchesToSave);

        return savedMatches.stream()
                .map(matchMapper::toResponseDTO)
                .toList();
    }


    @Override
    public MatchResponseDTO updateMatch(Long id, MatchRequestDTO matchRequestDTO) {

        repositoryMatch.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partido no encontrado"));

        Team homeTeam = repositoryTeam.getReferenceById(matchRequestDTO.getHomeTeamid());
        Team awayTeam = repositoryTeam.getReferenceById(matchRequestDTO.getAwayTeamid());
        Competition competition = repositoryCompetition.getReferenceById(matchRequestDTO.getCompetitionId());

        Match updateMatch = repositoryMatch.save(matchMapper.toEntity(homeTeam, awayTeam, competition, matchRequestDTO));

        return matchMapper.toResponseDTO(updateMatch);
    }



    @Override
    public void deleteById(Long id) {

        repositoryMatch.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partido no encontrado"));

        repositoryMatch.deleteById(id);
    }
}
