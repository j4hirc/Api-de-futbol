package com.football.proyectMarker.repository;

import com.football.proyectMarker.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryCountry extends JpaRepository<Country, Long> {

    @Query("SELECT c FROM Country c WHERE c.name = :nameCountry")
    Country findByName(@Param("nameCountry") String nameCountry);

}
