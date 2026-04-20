package com.football.proyectMarker.service.mapper;

import com.football.proyectMarker.dto.request.PlayerRequestDTO;
import com.football.proyectMarker.dto.response.PlayerResponseDTO;
import com.football.proyectMarker.model.Player;
import com.football.proyectMarker.model.Team;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerResponseDTO toResponseDTO(Player player){
        PlayerResponseDTO playerResponseDTO = new PlayerResponseDTO();
        playerResponseDTO.setName(player.getName());
        playerResponseDTO.setLastName(player.getLastName());
        playerResponseDTO.setJerseyNumber(player.getJerseyNumber());
        playerResponseDTO.setPosition(player.getPosition());
        playerResponseDTO.setAge(player.getAge());
        playerResponseDTO.setSobriquet(player.getSobriquet());
        playerResponseDTO.setNameTeam(player.getTeam().getName());
        return playerResponseDTO;
    }

    public Player toEntity(Team team, PlayerRequestDTO playerRequestDTO){
        Player player = new Player();
        player.setName(playerRequestDTO.getName());
        player.setAge(playerRequestDTO.getAge());
        player.setPosition(playerRequestDTO.getPosition());
        player.setLastName(playerRequestDTO.getLastName());
        player.setSobriquet(playerRequestDTO.getSobriquet());
        player.setJerseyNumber(playerRequestDTO.getJerseyNumber());
        player.setTeam(team);
        player.setRetired(playerRequestDTO.isRetired());
        return player;
    }

}
