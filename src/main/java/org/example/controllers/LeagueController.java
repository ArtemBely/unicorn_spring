package org.example.controllers;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.LeagueDto;
import org.example.data.entity.PersonEntity;
import org.example.services.LeagueService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/league")

public class LeagueController {
    private final LeagueService leagueService;

    @ResponseBody
    @PostMapping("/v1/insert")
    public void insertLeague(@Valid @RequestBody LeagueDto leagueDto) {
        log.info("start to insert league into psql, value: {}", leagueDto);
        leagueService.insert(leagueDto);
        log.info("end to insert league into psql, value: {}", leagueDto);
    }

    @Operation(summary="about")
    @GetMapping("/v1/join")
    public List<PersonEntity> joinTables() {
        log.info("start to join tables");
        return leagueService.joinWithPeople();
    }
}
