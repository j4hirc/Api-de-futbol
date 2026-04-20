package com.football.proyectMarker.service.implementation;

import com.football.proyectMarker.dto.request.CompetitionRequestDTO;
import com.football.proyectMarker.dto.response.CompetitionResponseDTO;
import com.football.proyectMarker.exception.ResourceNotFoundException;
import com.football.proyectMarker.model.Competition;
import com.football.proyectMarker.model.Country;
import com.football.proyectMarker.repository.RepositoryCompetition;
import com.football.proyectMarker.repository.RepositoryCountry;
import com.football.proyectMarker.service.CompetitionService;
import com.football.proyectMarker.service.mapper.CompetitionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private RepositoryCountry repositoryCountry;
    private RepositoryCompetition repositoryCompetition;
    private CompetitionMapper competitionMapper;


    @Override
    public List<CompetitionResponseDTO> findAll() {
        List<Competition> competitions = repositoryCompetition.findAll();

        return competitions.stream()
                .map(competitionMapper::toResponse)
                .toList();
    }

    @Override
    public CompetitionResponseDTO findByNameCountry(String nameCountry) {
        Competition competition = repositoryCompetition.findByNameCountry(nameCountry);

        return competitionMapper.toResponse(competition) ;
    }

    @Override
    public List<CompetitionResponseDTO> createCompetition(List<CompetitionRequestDTO> competitionRequestDTOS) {

        List<Competition> competitionsToSave = competitionRequestDTOS.stream()
                .map(competitionRequestDTO -> {
                    Country country = repositoryCountry.getReferenceById(competitionRequestDTO.getCity_id());
                    return competitionMapper.toEntity(country,competitionRequestDTO);
                        }).toList();

        List<Competition> competitionSaved = repositoryCompetition.saveAll(competitionsToSave);

        return competitionSaved.stream()
                .map(competitionMapper::toResponse)
                .toList();
    }

    @Override
    public CompetitionResponseDTO updateCompetition(Long id, CompetitionRequestDTO competitionRequestDTO) {
        repositoryCompetition.findById(id).orElseThrow(()-> new ResourceNotFoundException("Competicion no encontrada"));

        Country country = repositoryCountry.getReferenceById(competitionRequestDTO.getCity_id());

        Competition competitionSave = repositoryCompetition.save(competitionMapper.toEntity(country, competitionRequestDTO));

        return competitionMapper.toResponse(competitionSave);
    }



    @Override
    public void deleteById(Long id) {
        repositoryCompetition.findById(id).orElseThrow(()-> new ResourceNotFoundException("Competición no encontrada"));
        repositoryCompetition.deleteById(id);
    }


}
