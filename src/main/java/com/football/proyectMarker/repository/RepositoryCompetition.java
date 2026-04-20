package com.football.proyectMarker.repository;

import com.football.proyectMarker.model.Competition;
import com.football.proyectMarker.model.MatchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryCompetition extends JpaRepository<Competition, Long> {

    @Query("SELECT c FROM Competition c JOIN FETCH c.country p WHERE p.name = :nameCountry")
    Competition findByNameCountry(@Param("nameCountry") String nameCountry);



}
