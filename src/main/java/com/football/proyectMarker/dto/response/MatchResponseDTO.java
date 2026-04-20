package com.football.proyectMarker.dto.response;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchResponseDTO {

    private String homeTeamName;
    private String awayTeamName;
    private String competitionName;
    private LocalDate dateMatch;
    private String status;
    private Integer localScore;
    private Integer awayScoreboard;



}
