package com.football.proyectMarker.repository;

import com.football.proyectMarker.model.MatchEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryMatchEvent extends JpaRepository<MatchEvent, Long> {

    @Query("SELECT m FROM MatchEvent m JOIN FETCH m.match p WHERE p.id = :matchId")
    List<MatchEvent> findByIdMatch(@Param("matchId") Long matchId);

}
