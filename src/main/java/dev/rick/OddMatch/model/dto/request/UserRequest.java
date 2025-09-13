package dev.rick.OddMatch.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "O nome é obrigatorio")
        String name,
        @NotBlank(message = "O email é obrigatorio")
        @Email
        String email,
        @NotBlank(message = "A senha é obrigatorio")
        String password
) {
}
