package com.football.proyectMarker.service.implementation;

import com.football.proyectMarker.dto.request.MatchEventRequestDTO;
import com.football.proyectMarker.dto.response.MatchEventResponseDTO;
import com.football.proyectMarker.exception.ResourceNotFoundException;
import com.football.proyectMarker.model.Match;
import com.football.proyectMarker.model.MatchEvent;
import com.football.proyectMarker.repository.RepositoryMatch;
import com.football.proyectMarker.repository.RepositoryMatchEvent;
import com.football.proyectMarker.service.MatchEventService;
import com.football.proyectMarker.service.mapper.MatchEventMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatchEventServiceImpl implements MatchEventService {

    private RepositoryMatchEvent repositoryMatchEvent;
    private RepositoryMatch repositoryMatch;
    private MatchEventMapper matchEventMapper;


    @Override
    public List<MatchEventResponseDTO> findByIdMatch(Long matchId) {

        List<MatchEvent> matchEvents = repositoryMatchEvent.findByIdMatch(matchId);
        if(matchEvents.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron eventos");
        }

        return matchEvents.stream()
                .map(matchEventMapper::toResponse)
                .toList();
    }


    @Override
    public List<MatchEventResponseDTO> createMatchEvent(List<MatchEventRequestDTO> matchEventRequestDTO) {

        List<MatchEvent> matchEvents = matchEventRequestDTO.stream()
                .map(dto -> {
                    Match match = repositoryMatch.getReferenceById(dto.getMatchId());
                    return matchEventMapper.toEntity(match, dto);
                }).toList();

        List<MatchEvent> matchEventSaved = repositoryMatchEvent.saveAll(matchEvents);

        return matchEventSaved.stream()
                .map(matchEventMapper::toResponse)
                .toList();
    }



    @Override
    public MatchEventResponseDTO updateMatchEvent(Long matchEventId, MatchEventRequestDTO matchEventRequestDTO) {

        repositoryMatchEvent.findById(matchEventId)
                .orElseThrow(() -> new ResourceNotFoundException ("Evento no encontrado"));

        Match match = repositoryMatch.getReferenceById(matchEventRequestDTO.getMatchId());

        MatchEvent updateMatchEvent = repositoryMatchEvent.save(matchEventMapper.toEntity(match, matchEventRequestDTO));

        return matchEventMapper.toResponse(updateMatchEvent);
    }

    @Override
    public void deleteById(Long id) {
        repositoryMatchEvent.findById(id).orElseThrow(() -> new ResourceNotFoundException("Evento del partido no encontrado"));
        repositoryMatchEvent.deleteById(id);

    }
}
