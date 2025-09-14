package dev.rick.OddMatch.controller;

import dev.rick.OddMatch.model.dto.mapper.UserMapper;
import dev.rick.OddMatch.model.dto.request.UserRequest;
import dev.rick.OddMatch.model.dto.response.UserResponse;
import dev.rick.OddMatch.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/salvar")
    public ResponseEntity<UserResponse> save (@RequestBody UserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toResponse(service
                        .save(UserMapper.toUser(request))));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<UserResponse>> findAll(){
        List<UserResponse> users = service.findAll().stream()
                .map(UserMapper::toResponse)
                .toList();
        return ResponseEntity.ok(users);
    }


}
