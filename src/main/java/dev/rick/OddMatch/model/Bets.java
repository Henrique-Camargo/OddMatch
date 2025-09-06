package dev.rick.OddMatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Bets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime criadoEm;
    private LocalDateTime horarioJogo;
    private Boolean situation;
    private Double stake;
    private Double odds;
    private Double value;


}
