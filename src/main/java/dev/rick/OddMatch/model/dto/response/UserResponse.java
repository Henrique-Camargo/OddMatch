package dev.rick.OddMatch.model.dto.response;

import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email
) {
}
