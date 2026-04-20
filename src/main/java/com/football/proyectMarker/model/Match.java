package com.football.proyectMarker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches", uniqueConstraints = {@UniqueConstraint( name = "noDuplicate_match_teams_competition",
        columnNames ={"home_team_id", "away_team_id", "competition_id"})})
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    private Integer localScore;

    private Integer awayScoreboard;

    @Column(nullable = false)
    private LocalDate dateMatch;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;



}
