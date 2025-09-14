package dev.rick.OddMatch.model.dto.response;

import dev.rick.OddMatch.model.dto.enums.BetStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BetsResponse(
        Long id,
        LocalDateTime localDateTime,
        Double stake,
        Double odds,
        BetStatus status,
        Long accountsId,
        String accountsName,
        Long houseId,
        String houseName,
        Long eventId,
        String eventName
) {
}
