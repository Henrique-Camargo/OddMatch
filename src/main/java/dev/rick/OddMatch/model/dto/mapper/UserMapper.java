package dev.rick.OddMatch.model.dto.mapper;

import dev.rick.OddMatch.model.Users;
import dev.rick.OddMatch.model.dto.request.UserRequest;
import dev.rick.OddMatch.model.dto.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static Users toUser (UserRequest request){
        return Users
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toResponse (Users users){
        return UserResponse
                .builder()
                .id(users.getId())
                .name(users.getName())
                .email(users.getEmail())
                .build();
    }

}
