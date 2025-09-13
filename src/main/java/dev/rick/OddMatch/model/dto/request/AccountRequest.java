package dev.rick.OddMatch.model.dto.request;

import dev.rick.OddMatch.model.Users;
import jakarta.validation.constraints.NotBlank;

public record AccountRequest(
        @NotBlank(message = "O nome é obrigatorio")
        String name,
        @NotBlank
        Long userId,
        String login,
        String password
) {
}
