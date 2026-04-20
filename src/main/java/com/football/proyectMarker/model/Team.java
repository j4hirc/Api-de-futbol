package com.football.proyectMarker.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    private String stadium;


    @Column(nullable = false, updatable = false)
    private LocalDateTime creation;

    @PrePersist
    protected void onCreate() {
        if (this.creation == null) {
            this.creation = LocalDateTime.now();
        }
    }

}
