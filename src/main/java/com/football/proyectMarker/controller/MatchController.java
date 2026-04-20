package com.football.proyectMarker.controller;


import com.football.proyectMarker.dto.request.MatchRequestDTO;
import com.football.proyectMarker.dto.response.MatchResponseDTO;
import com.football.proyectMarker.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/matches")
@AllArgsConstructor
public class MatchController {

    private MatchService matchService;

    @GetMapping("/{name}")
    public  ResponseEntity<List<MatchResponseDTO>> getNameTeam(@PathVariable String name){
        List<MatchResponseDTO> matchResponseDTOS = matchService.findByNameTeam(name);
        return new ResponseEntity<>(matchResponseDTOS, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<MatchResponseDTO>> getAllMatches(){
     List<MatchResponseDTO> matches = matchService.findAllMatches();
     return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<MatchResponseDTO>> createMatch(@RequestBody List<MatchRequestDTO> matchRequestDTOs){
        List<MatchResponseDTO>  responseDTOs = matchService.createMatch(matchRequestDTOs);
        return new ResponseEntity<>(responseDTOs, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> updateMatch(@PathVariable Long id,
                                                        @RequestBody MatchRequestDTO matchRequestDTO){
        MatchResponseDTO responseDTO = matchService.updateMatch(id, matchRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        matchService.deleteById(id);
    }



}
