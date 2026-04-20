package com.football.proyectMarker.controller;

import com.football.proyectMarker.dto.request.CompetitionRequestDTO;
import com.football.proyectMarker.dto.response.CompetitionResponseDTO;
import com.football.proyectMarker.service.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/competitions")
@AllArgsConstructor
public class CompetitionController {

    private CompetitionService competitionService;

    @GetMapping
    public ResponseEntity<List<CompetitionResponseDTO>> findAll(){
        List<CompetitionResponseDTO> competitionResponseDTOS = competitionService.findAll();
        return new ResponseEntity<>(competitionResponseDTOS, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CompetitionResponseDTO> findByName(@PathVariable String name){
        CompetitionResponseDTO competitionResponseDTO = competitionService.findByNameCountry(name);
        return new ResponseEntity<>(competitionResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<CompetitionResponseDTO>> createCompetition(List<CompetitionRequestDTO> competitionRequestDTO){
        List<CompetitionResponseDTO> competitionResponseDTOList = competitionService.createCompetition(competitionRequestDTO);
        return new ResponseEntity<>(competitionResponseDTOList, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<CompetitionResponseDTO> updateCompetition(@PathVariable Long id, CompetitionRequestDTO competitionRequestDTO){
        CompetitionResponseDTO competitionResponseDTO = competitionService.updateCompetition(id, competitionRequestDTO);
        return new ResponseEntity<>(competitionResponseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        competitionService.deleteById(id);
    }



}
