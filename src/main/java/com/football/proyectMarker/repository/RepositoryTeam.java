package com.football.proyectMarker.repository;

import com.football.proyectMarker.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryTeam extends JpaRepository<Team, Long> {

    @Query("SELECT t FROM Team t JOIN FETCH t.country c WHERE c.id = :countryId")
    List<Team> findByCountryId(@Param("countryId") Long id);

    @Query("SELECT t FROM Team t JOIN FETCH t.country")
    List<Team> findAllTeam();


}
