package dev.rick.OddMatch.model.dto.response;

import lombok.Builder;

@Builder
public record HousesResponse(
        Long id,
        String name,
        Double balance
) {
}
