package com.football.proyectMarker.controller;

import com.football.proyectMarker.dto.request.MatchEventRequestDTO;
import com.football.proyectMarker.dto.response.MatchEventResponseDTO;
import com.football.proyectMarker.service.MatchEventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/matchEvents")
@AllArgsConstructor
public class MatchEventController {

    private MatchEventService matchEventService;

    @PostMapping
    public ResponseEntity<List<MatchEventResponseDTO>> createMatch(@RequestBody  List<MatchEventRequestDTO> matchEventRequestDTO){
        List<MatchEventResponseDTO> matchEventResponseDTOS = matchEventService.createMatchEvent(matchEventRequestDTO);
        return new ResponseEntity<>(matchEventResponseDTOS, HttpStatus.CREATED);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<List<MatchEventResponseDTO>> getByIdMatch(@PathVariable Long matchId){
        List<MatchEventResponseDTO> matchEventResponseDTOS = matchEventService.findByIdMatch(matchId);
        return new ResponseEntity<>(matchEventResponseDTOS, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<MatchEventResponseDTO> updateMatch(@PathVariable Long id,
                                                             @RequestBody MatchEventRequestDTO matchEventRequestDTO){

        MatchEventResponseDTO matchEventResponseDTO = matchEventService.updateMatchEvent(id, matchEventRequestDTO);

        return new ResponseEntity<>(matchEventResponseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        matchEventService.deleteById(id);
    }



}
