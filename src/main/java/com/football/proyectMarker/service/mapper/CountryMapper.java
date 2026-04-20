package com.football.proyectMarker.service.mapper;

import com.football.proyectMarker.dto.response.CountryResponseDTO;
import com.football.proyectMarker.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryResponseDTO toResponse(Country country){
        CountryResponseDTO countryResponseDTO = new CountryResponseDTO();
        countryResponseDTO.setName(country.getName());
        return countryResponseDTO;
    }


}
