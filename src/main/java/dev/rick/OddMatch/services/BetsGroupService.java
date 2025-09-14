package dev.rick.OddMatch.services;

import dev.rick.OddMatch.model.Bets;
import dev.rick.OddMatch.model.dto.request.BetGroupResponse;
import dev.rick.OddMatch.repository.BetsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetsGroupService {

    private final BetsRepository betRepository;

    public BetGroupResponse calculateBetGroup(List<Long> betIds) {
        List<Bets> bets = betRepository.findAllById(betIds);

        double totalStake = bets.stream()
                .mapToDouble(Bets::getStake)
                .sum();

        double totalPotentialReturn = bets.stream()
                .mapToDouble(bet -> bet.getStake() * bet.getOdds())
                .sum();

        double totalProfit = bets.stream()
                .mapToDouble(bet -> {
                    switch (bet.getStatus()) {
                        case VENCEU -> { return bet.getStake() * (bet.getOdds() - 1); }
                        case PERDEU -> { return -bet.getStake(); }
                        default -> { return 0; }
                    }
                })
                .sum();

        return new BetGroupResponse(totalStake, totalPotentialReturn, totalProfit);
    }
}
