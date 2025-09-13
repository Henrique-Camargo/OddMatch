package dev.rick.OddMatch.model.dto.response;

import dev.rick.OddMatch.model.Users;
import lombok.Builder;

@Builder
public record AccountResponse(
        Long id,
        String name,
        Long userId,
        String userName,
        String login
) {
}
