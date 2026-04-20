package com.football.proyectMarker.dto.request;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDTO {

    private Long homeTeamid;
    private Long awayTeamid;
    private Long CompetitionId;
    private LocalDate dateMatch;
    private String status;
    private Integer localScore;
    private Integer awayScoreboard;


}
