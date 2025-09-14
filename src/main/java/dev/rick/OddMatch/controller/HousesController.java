package dev.rick.OddMatch.controller;

import dev.rick.OddMatch.model.dto.mapper.HousesMapper;
import dev.rick.OddMatch.model.dto.request.HousesRequest;
import dev.rick.OddMatch.model.dto.response.HousesResponse;
import dev.rick.OddMatch.services.HousesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casas")
@RequiredArgsConstructor
public class HousesController {

    private final HousesService service;

    @PostMapping("/salvar")
    public ResponseEntity<HousesResponse> save(@RequestBody HousesRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(HousesMapper.toResponse(service
                        .save(HousesMapper.toHouse(request))));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<HousesResponse>> findAll(){
        List<HousesResponse> houses = service.findAll().stream()
                .map(HousesMapper::toResponse)
                .toList();
        return ResponseEntity.ok(houses);
    }

}
