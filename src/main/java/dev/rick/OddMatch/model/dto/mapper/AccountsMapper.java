package dev.rick.OddMatch.model.dto.mapper;

import dev.rick.OddMatch.model.Accounts;
import dev.rick.OddMatch.model.Users;
import dev.rick.OddMatch.model.dto.request.AccountRequest;
import dev.rick.OddMatch.model.dto.response.AccountResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountsMapper {

    public static Accounts toAccount(AccountRequest accountRequest){
        return Accounts
                .builder()
                .name(accountRequest.name())
                .user(Users.builder().id(accountRequest.userId()).build())
                .login(accountRequest.login())
                .password(accountRequest.password())
                .build();
    }

    public static AccountResponse toResponse(Accounts account){
        Long userId = account.getUser() != null ? account.getUser().getId() : null;
        String userName = account.getUser() != null ? account.getUser().getName() : null;

        return AccountResponse.builder()
                .id(account.getId())
                .name(account.getName())
                .userId(userId)
                .userName(userName)
                .login(account.getLogin())
                .build();
    }

}
