package dev.rick.OddMatch.model.dto.mapper;

import dev.rick.OddMatch.model.Bets;
import dev.rick.OddMatch.model.Users;
import dev.rick.OddMatch.model.dto.request.BetsRequest;
import dev.rick.OddMatch.model.dto.response.BetsResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BetsMappper {

    public static Bets toBets (BetsRequest request){
        return Bets
                .builder()
                .criadoEm(request.localDateTime())
                .stake(request.stake())
                .odds(request.odds())
                .status(request.status())
                .accounts(Bets.builder().id(request.accountsId()).build().getAccounts())
                .houses(Bets.builder().id(request.houseId()).build().getHouses())
                .event(Bets.builder().id(request.eventId()).build().getEvent())
                .build();
    }

    public static BetsResponse toResponse(Bets bets){
        Long accountId = bets.getAccounts() != null ? bets.getAccounts().getId() : null;
        String accountName = bets.getAccounts() != null ? bets.getAccounts().getName() : null;

        Long houseId = bets.getHouses() != null ? bets.getHouses().getId() : null;
        String houseName = bets.getHouses() != null ? bets.getHouses().getName() : null;

        Long eventId = bets.getEvent() != null ? bets.getEvent().getId() : null;
        String eventName = bets.getEvent() != null ? bets.getEvent().getName() : null;

        return BetsResponse
                .builder()
                .id(bets.getId())
                .localDateTime(bets.getCriadoEm())
                .stake(bets.getStake())
                .odds(bets.getOdds())
                .status(bets.getStatus())
                .accountsId(accountId)
                .accountsName(accountName)
                .houseId(houseId)
                .houseName(houseName)
                .eventId(eventId)
                .eventName(eventName)
                .build();
    }

}
