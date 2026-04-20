package com.football.proyectMarker.repository;

import com.football.proyectMarker.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryPlayer  extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p JOIN FETCH p.team t WHERE t.id = :teamId")
    List<Player> findByteamId(@Param("teamId") Long teamId);

}
