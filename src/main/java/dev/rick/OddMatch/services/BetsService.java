package dev.rick.OddMatch.services;

import dev.rick.OddMatch.model.Accounts;
import dev.rick.OddMatch.model.Bets;
import dev.rick.OddMatch.model.Event;
import dev.rick.OddMatch.model.Houses;
import dev.rick.OddMatch.model.dto.request.BetsRequest;
import dev.rick.OddMatch.repository.AccountsRepository;
import dev.rick.OddMatch.repository.BetsRepository;
import dev.rick.OddMatch.repository.EventRepository;
import dev.rick.OddMatch.repository.HousesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BetsService {

    private final BetsRepository betsRepository;
    private final AccountsRepository accountsRepository;
    private final HousesRepository housesRepository;
    private final EventRepository eventRepository;

    public Bets save(BetsRequest request) {
        Accounts account = accountsRepository.findById(request.accountsId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        Houses house = housesRepository.findById(request.houseId())
                .orElseThrow(() -> new RuntimeException("Casa não encontrada"));
        Event event = eventRepository.findById(request.eventId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Bets bet = Bets.builder()
                .criadoEm(LocalDateTime.now())
                .stake(request.stake())
                .odds(request.odds())
                .status(request.status())
                .accounts(account)
                .houses(house)
                .event(event)
                .build();

        return betsRepository.save(bet);
    }


    public List<Bets> findAll(){
        return betsRepository.findAll();
    }

    public Optional<Bets> findById(Long id){
        return betsRepository.findById(id);
    }

    public void deleteById(Long id){
        betsRepository.deleteById(id);
    }

}
