package com.football.proyectMarker.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchEventRequestDTO {

    private Long matchId;

    private String event;

    private Integer matchMinute;

    private String description;



}
