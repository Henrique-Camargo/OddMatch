package dev.rick.OddMatch.services;

import dev.rick.OddMatch.model.Event;
import dev.rick.OddMatch.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;

    public Event save(Event event){
        return repository.save(event);
    }

    public List<Event> findAll(){
        return repository.findAll();
    }

    public Optional<Event> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
