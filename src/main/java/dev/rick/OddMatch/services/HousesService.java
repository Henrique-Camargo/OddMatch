package dev.rick.OddMatch.services;

import dev.rick.OddMatch.model.Houses;
import dev.rick.OddMatch.repository.HousesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HousesService {

    private final HousesRepository repository;

    public Houses save(Houses houses){
        return repository.save(houses);
    }

    public List<Houses> findAll (){
        return repository.findAll();
    }

    public Optional<Houses> findById (Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
