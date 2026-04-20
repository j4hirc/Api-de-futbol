package com.football.proyectMarker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequestDTO {

    private String name;

    private String lastName;

    private Integer jerseyNumber;

    private String position;

    private Integer age;

    private String sobriquet;

    private boolean retired;

    private Long teamId;


}
