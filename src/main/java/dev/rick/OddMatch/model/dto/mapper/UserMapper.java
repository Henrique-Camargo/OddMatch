package dev.rick.OddMatch.model.dto.mapper;

import dev.rick.OddMatch.model.Users;
import dev.rick.OddMatch.model.dto.request.UserRequest;
import dev.rick.OddMatch.model.dto.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static Users toUser (UserRequest userRequest){
        return Users
                .builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
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
