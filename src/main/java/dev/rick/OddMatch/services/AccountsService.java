package dev.rick.OddMatch.services;

import dev.rick.OddMatch.model.Accounts;
import dev.rick.OddMatch.model.Users;
import dev.rick.OddMatch.model.dto.mapper.AccountsMapper;
import dev.rick.OddMatch.model.dto.request.AccountRequest;
import dev.rick.OddMatch.model.dto.response.AccountResponse;
import dev.rick.OddMatch.repository.AccountsRepository;
import dev.rick.OddMatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsService {

    private final AccountsRepository repository;
    private final UserRepository userRepository;

    public AccountResponse save(AccountRequest request) {
        Users user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Accounts account = Accounts.builder()
                .name(request.name())
                .user(user)
                .login(request.login())
                .password(request.password())
                .build();

        Accounts saved = repository.save(account);
        return AccountsMapper.toResponse(saved);
    }

    public List<AccountResponse> findAll() {
        return repository.findAll().stream()
                .map(AccountsMapper::toResponse)
                .toList();
    }

    public AccountResponse findById(Long id) {
        Accounts account = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountsMapper.toResponse(account);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
