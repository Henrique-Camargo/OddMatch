package dev.rick.OddMatch.controller;

import dev.rick.OddMatch.model.dto.request.AccountRequest;
import dev.rick.OddMatch.model.dto.response.AccountResponse;
import dev.rick.OddMatch.services.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsService service;

    @PostMapping("/salvar")
    public ResponseEntity<AccountResponse> save(@RequestBody AccountRequest request){
        AccountResponse response = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<AccountResponse>> findAll(){
        List<AccountResponse> accounts = service.findAll();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AccountResponse> findById(@PathVariable Long id){
        return ResponseEntity
                .ok(service.findById(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
