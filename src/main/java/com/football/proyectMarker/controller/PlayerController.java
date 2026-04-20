package com.football.proyectMarker.controller;


import com.football.proyectMarker.dto.request.PlayerRequestDTO;
import com.football.proyectMarker.dto.response.PlayerResponseDTO;
import com.football.proyectMarker.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player")
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("/{teamId}")
    public ResponseEntity<List<PlayerResponseDTO>> getAllByTeamId(@PathVariable Long teamId){
        List<PlayerResponseDTO> playerResponseDTOS = playerService.findAllByTeamId(teamId);
        return new ResponseEntity<>(playerResponseDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<PlayerResponseDTO>> createPlayer(@RequestBody List<PlayerRequestDTO> playerRequestDTO) {
        List<PlayerResponseDTO> playerResponseDTOS = playerService.createPlayers(playerRequestDTO);
        return new ResponseEntity<>(playerResponseDTOS, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerRequestDTO playerRequestDTO) {
        PlayerResponseDTO playerResponseDTO = playerService.updatePlayer(id, playerRequestDTO);
        return new ResponseEntity<>(playerResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        playerService.deleteById(id);
    }



}
