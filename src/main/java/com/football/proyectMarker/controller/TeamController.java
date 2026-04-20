package com.football.proyectMarker.controller;


import com.football.proyectMarker.dto.response.TeamResponseDTO;
import com.football.proyectMarker.dto.request.TeamResquestDTO;
import com.football.proyectMarker.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/team")
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAll(){
        List<TeamResponseDTO> teamResponseDTOS = teamService.findAll();
        return new ResponseEntity<>(teamResponseDTOS, HttpStatus.OK);
    }


    @GetMapping("/forCountry/{id}")
    public ResponseEntity<List<TeamResponseDTO>> getTeamByCountry(@PathVariable Long id){
        List<TeamResponseDTO> teams = teamService.findByCountry(id);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamResponseDTO> createTeam(@RequestBody TeamResquestDTO teamResquestDTO){
        TeamResponseDTO teamResponseDTO = teamService.Save(teamResquestDTO);
        return new ResponseEntity<>(teamResponseDTO, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> updateTeam(@PathVariable Long id, TeamResquestDTO teamResquestDTO){
        TeamResponseDTO teamResponseDTO = teamService.updateTeam(id, teamResquestDTO);
        return  new ResponseEntity<>(teamResponseDTO, HttpStatus.OK);
    }


}
