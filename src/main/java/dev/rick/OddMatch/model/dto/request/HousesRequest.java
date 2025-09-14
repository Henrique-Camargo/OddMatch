package dev.rick.OddMatch.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record HousesRequest(
        @NotBlank(message = "O nome da Casa de aposta é obrigatorio")
        String name,
        Double balance
) {
}
