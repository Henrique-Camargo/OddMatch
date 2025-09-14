package dev.rick.OddMatch.model.dto.mapper;

import dev.rick.OddMatch.model.Houses;
import dev.rick.OddMatch.model.dto.request.HousesRequest;
import dev.rick.OddMatch.model.dto.response.HousesResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HousesMapper {

    public Houses toHouse (HousesRequest request){
        return Houses
                .builder()
                .name(request.name())
                .balance(request.balance())
                .build();
    }

    public HousesResponse toResponse (Houses houses){
        return HousesResponse
                .builder()
                .id(houses.getId())
                .name(houses.getName())
                .balance(houses.getBalance())
                .build();
    }
}
