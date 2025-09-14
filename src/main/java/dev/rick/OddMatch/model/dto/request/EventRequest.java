package dev.rick.OddMatch.model.dto.request;

import dev.rick.OddMatch.model.dto.enums.Sports;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record EventRequest(
        @NotBlank(message = "O nome do Evento é obrigatorio")
        String name,
        @NotBlank(message = "O tipo de esporte é obrigatorio")
        Sports sports,
        LocalDateTime localDateTime
) {
}
