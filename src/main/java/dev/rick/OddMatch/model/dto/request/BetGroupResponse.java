package dev.rick.OddMatch.model.dto.request;

public record BetGroupResponse(
        Double totalStake,
        Double totalPotentialReturn,
        Double totalProfit
) {
}
