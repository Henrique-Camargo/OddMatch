package dev.rick.OddMatch.services;

import dev.rick.OddMatch.model.Users;
import dev.rick.OddMatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Users save (Users users){
        return repository.save(users);
    }

    public List<Users> findAll (){
        return repository.findAll();
    }

    public Optional<Users> findById (Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
