package dev.rick.OddMatch.model;

import dev.rick.OddMatch.model.dto.enums.BetStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime criadoEm;
    private Double stake;
    private Double odds;

    @Enumerated
    private BetStatus status;

    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Accounts accounts;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private Houses houses;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
