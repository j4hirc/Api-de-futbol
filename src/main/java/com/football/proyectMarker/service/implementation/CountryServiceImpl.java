package com.football.proyectMarker.service.implementation;

import com.football.proyectMarker.dto.response.CountryResponseDTO;
import com.football.proyectMarker.exception.ResourceNotFoundException;
import com.football.proyectMarker.model.Country;
import com.football.proyectMarker.repository.RepositoryCountry;
import com.football.proyectMarker.service.CountryService;
import com.football.proyectMarker.service.mapper.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private RepositoryCountry repositoryCountry;
    private CountryMapper countryMapper;


    @Override
    public CountryResponseDTO findByName(String name) {
        Country countryName = repositoryCountry.findByName(name);
        return countryMapper.toResponse(countryName);
    }

    @Override
    public List<CountryResponseDTO> findAll() {
        List<Country> countries = repositoryCountry.findAll();

        return countries.stream()
                .map(countryMapper::toResponse)
                .toList();
    }

    @Override
    public List<CountryResponseDTO> createCountry(List<Country> countries) {
        List<Country> countriesSaved = repositoryCountry.saveAll(countries);

        return countriesSaved.stream()
                .map(countryMapper::toResponse)
                .toList();
    }

    @Override
    public CountryResponseDTO updateCountry(Long id, Country country) {
        Country CountryUpdate = repositoryCountry.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pais no encontrado"));

        Country countrySaved = repositoryCountry.save(CountryUpdate);
        return countryMapper.toResponse(countrySaved);
    }

    @Override
    public void deleteById(Long id) {
        repositoryCountry.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pais no encontrada"));
        repositoryCountry.deleteById(id);
    }


}
