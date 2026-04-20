package com.football.proyectMarker.service;

import com.football.proyectMarker.dto.response.CountryResponseDTO;
import com.football.proyectMarker.model.Country;

import java.util.List;

public interface CountryService {

    CountryResponseDTO findByName(String name);

    List<CountryResponseDTO> findAll();

    List<CountryResponseDTO>  createCountry(List<Country> country);

    CountryResponseDTO updateCountry(Long id, Country country);

    void deleteById(Long id);



}
