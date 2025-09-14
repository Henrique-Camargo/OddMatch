package dev.rick.OddMatch.controller;

import dev.rick.OddMatch.model.dto.request.BetGroupResponse;
import dev.rick.OddMatch.services.BetsGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bets-group")
@RequiredArgsConstructor
public class BetsGroupController {

    private final BetsGroupService betsGroupService;

    @GetMapping("/calculate")
    public ResponseEntity<BetGroupResponse> calculate(@RequestParam List<Long> betIds) {
        BetGroupResponse response = betsGroupService.calculateBetGroup(betIds);
        return ResponseEntity.ok(response);
    }
}
