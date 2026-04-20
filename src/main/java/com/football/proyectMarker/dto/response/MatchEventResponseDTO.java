package com.football.proyectMarker.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MatchEventResponseDTO {

    private String event;

    private Integer matchMinute;

    private String description;



}
