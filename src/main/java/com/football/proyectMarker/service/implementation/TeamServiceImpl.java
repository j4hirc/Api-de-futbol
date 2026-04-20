package com.football.proyectMarker.service.implementation;

import com.football.proyectMarker.dto.response.TeamResponseDTO;
import com.football.proyectMarker.dto.request.TeamResquestDTO;
import com.football.proyectMarker.exception.ResourceNotFoundException;
import com.football.proyectMarker.model.Country;
import com.football.proyectMarker.model.Team;
import com.football.proyectMarker.repository.RepositoryCountry;
import com.football.proyectMarker.repository.RepositoryTeam;
import com.football.proyectMarker.service.TeamService;
import com.football.proyectMarker.service.mapper.TeamMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private RepositoryTeam repositoryTeam;
    private RepositoryCountry repositoryCountry;
    private TeamMapper teamMapper;


    @Override
    public List<TeamResponseDTO> findAll() {
        List<Team> teams = repositoryTeam.findAllTeam();

        if(teams.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron equipos");
        }

        return teams.stream()
                .map(teamMapper::toResponseDTO)
                .toList();
    }


    @Override
    public List<TeamResponseDTO> findByCountry(Long id) {
        List<Team> teams = repositoryTeam.findByCountryId(id);

        if(teams.isEmpty()){
            throw new ResourceNotFoundException("No se encontraron equipos en el pais: " + id);
        }

        return teams.stream()
                .map(teamMapper::toResponseDTO)
                .toList();
    }


    @Override
    public TeamResponseDTO Save(TeamResquestDTO teamResquestDTO) {

        Country country = repositoryCountry.getReferenceById(teamResquestDTO.getCountryId());
        Team saveTeam = repositoryTeam.save(teamMapper.ToEntity(country, teamResquestDTO));

        return teamMapper.toResponseDTO(saveTeam);
    }



    @Override
    public TeamResponseDTO updateTeam(Long id, TeamResquestDTO teamResquestDTO) {

        repositoryTeam.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Equipo no encontrado"));

        Country country = repositoryCountry.getReferenceById(teamResquestDTO.getCountryId());
        Team updateTeam = repositoryTeam.save(teamMapper.ToEntity(country, teamResquestDTO));

        return teamMapper.toResponseDTO(updateTeam);
    }


}
