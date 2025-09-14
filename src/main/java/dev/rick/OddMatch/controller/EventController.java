package dev.rick.OddMatch.controller;

import dev.rick.OddMatch.model.dto.mapper.EventMapper;
import dev.rick.OddMatch.model.dto.request.EventRequest;
import dev.rick.OddMatch.model.dto.response.EventResponse;
import dev.rick.OddMatch.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @PostMapping("/salvar")
    public ResponseEntity<EventResponse> save(@RequestBody EventRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EventMapper.toResponse(service
                        .save(EventMapper.toEvent(request))));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<EventResponse>>findAll(){
        List<EventResponse> eventos = service.findAll().stream()
                .map(EventMapper::toResponse)
                .toList();
        return ResponseEntity.ok(eventos);
    }
}
