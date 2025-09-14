package dev.rick.OddMatch.controller;

import dev.rick.OddMatch.model.Bets;
import dev.rick.OddMatch.model.dto.mapper.BetsMappper;
import dev.rick.OddMatch.model.dto.request.BetsRequest;
import dev.rick.OddMatch.model.dto.response.BetsResponse;
import dev.rick.OddMatch.services.BetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apostas")
@RequiredArgsConstructor
public class BetsController {

    private final BetsService service;

    @PostMapping("/salvar")
    public ResponseEntity<BetsResponse> save(@RequestBody BetsRequest request) {
        Bets saved = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BetsMappper.toResponse(saved));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<BetsResponse>>findAll(){
        List<BetsResponse> bets = service.findAll().stream()
                .map(BetsMappper::toResponse)
                .toList();
        return ResponseEntity.ok(bets);
    }


}
