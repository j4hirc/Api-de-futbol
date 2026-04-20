package com.football.proyectMarker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamResquestDTO {

    private String name;

    private Long countryId;

    private String stadium;


}
