package com.football.proyectMarker.service.implementation;

import com.football.proyectMarker.dto.request.PlayerRequestDTO;
import com.football.proyectMarker.dto.response.PlayerResponseDTO;
import com.football.proyectMarker.exception.ResourceNotFoundException;
import com.football.proyectMarker.model.Player;
import com.football.proyectMarker.model.Team;
import com.football.proyectMarker.repository.RepositoryPlayer;
import com.football.proyectMarker.repository.RepositoryTeam;
import com.football.proyectMarker.service.PlayerService;
import com.football.proyectMarker.service.mapper.PlayerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private RepositoryPlayer repositoryPlayer;
    private RepositoryTeam repositoryTeam;
    private PlayerMapper playerMapper;


    @Override
    public List<PlayerResponseDTO> findAllByTeamId(Long teamId) {

        repositoryTeam.findById(teamId).orElseThrow(()-> new ResourceNotFoundException("No existe ese equipo"));

        List<Player> players = repositoryPlayer.findByteamId(teamId);

        if(players.isEmpty()){
            throw new ResourceNotFoundException(("Jugadores no encontrados"));
        }

        return players.stream()
                .map(playerMapper::toResponseDTO)
                .toList();
    }



    @Override
    public List<PlayerResponseDTO> createPlayers(List<PlayerRequestDTO> playerRequestDTOS) {

        List<Player> playerToSave = playerRequestDTOS.stream()
                .map(dto -> {
                    Team team = repositoryTeam.getReferenceById(dto.getTeamId());
                    return playerMapper.toEntity(team, dto);
                }).toList();

        List<Player> playerSaved = repositoryPlayer.saveAll(playerToSave);

        return playerSaved.stream()
                .map(playerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PlayerResponseDTO updatePlayer(Long id, PlayerRequestDTO playerRequestDTO) {

        repositoryPlayer.findById(id).orElseThrow(()-> new ResourceNotFoundException("Jugador no encontrado"));

        Team teamUpdate = repositoryTeam.getReferenceById(playerRequestDTO.getTeamId());

        Player updatePlayer = repositoryPlayer.save(playerMapper.toEntity(teamUpdate, playerRequestDTO));

        return playerMapper.toResponseDTO(updatePlayer);
    }

    @Override
    public void deleteById(Long id) {
        repositoryPlayer.findById(id).orElseThrow(()-> new ResourceNotFoundException("Jugador no encontrado"));
        repositoryPlayer.deleteById(id);
    }


}
