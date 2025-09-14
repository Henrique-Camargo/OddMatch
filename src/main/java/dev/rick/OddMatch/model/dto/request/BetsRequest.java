package dev.rick.OddMatch.model.dto.request;

import dev.rick.OddMatch.model.dto.enums.BetStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record BetsRequest(
        LocalDateTime localDateTime,
        Double stake,
        Double odds,
        BetStatus status,
        Long accountsId,
        Long houseId,
        Long eventId
) {
}
