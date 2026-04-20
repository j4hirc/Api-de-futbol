package com.football.proyectMarker.controller;

import com.football.proyectMarker.dto.response.CountryResponseDTO;
import com.football.proyectMarker.model.Country;
import com.football.proyectMarker.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/{name}")
    public ResponseEntity<CountryResponseDTO> findByName(@PathVariable String name){
        CountryResponseDTO countryResponseDTO = countryService.findByName(name);
        return new ResponseEntity<>(countryResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CountryResponseDTO>> findAll(){
        List<CountryResponseDTO> countryResponseDTOS = countryService.findAll();
        return new ResponseEntity<>(countryResponseDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<CountryResponseDTO>> saveCountry(@RequestBody List<Country> countries){
        List<CountryResponseDTO> countryResponseDTOS = countryService.createCountry(countries);
        return new ResponseEntity<>(countryResponseDTOS, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CountryResponseDTO> updateCountry(@PathVariable Long id,@RequestBody Country country){
        CountryResponseDTO countryResponseDTO = countryService.updateCountry(id, country);
        return new ResponseEntity<>(countryResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        countryService.deleteById(id);
    }



}
