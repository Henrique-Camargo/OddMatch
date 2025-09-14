package dev.rick.OddMatch.model.dto.response;

import dev.rick.OddMatch.model.dto.enums.Sports;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventResponse(
        Long id,
        String name,
        Sports sports,
        LocalDateTime localDateTime
) {
}
