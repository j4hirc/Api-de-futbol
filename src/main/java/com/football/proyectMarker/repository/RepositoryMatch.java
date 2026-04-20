package com.football.proyectMarker.repository;

import com.football.proyectMarker.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RepositoryMatch extends JpaRepository<Match, Long> {

    @Query("SELECT m FROM Match m " +
            "JOIN FETCH m.homeTeam " +
            "JOIN FETCH m.awayTeam " +
            "LEFT JOIN FETCH m.competition")
    List<Match> findAllMatchesWithDetails();

    @Query("SELECT m FROM Match m " +
            "JOIN FETCH m.homeTeam " +
            "JOIN FETCH m.awayTeam " +
            "LEFT JOIN FETCH m.competition " +
            "WHERE m.homeTeam.name = :teamName OR  m.awayTeam.name = :teamName")
    List<Match> findByNameTeam(@Param("teamName")String name);

}
