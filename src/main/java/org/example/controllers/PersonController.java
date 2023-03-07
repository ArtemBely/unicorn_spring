package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.example.data.dto.PersonDto;
import org.example.services.PersonService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")

public class PersonController {
    private final PersonService personService;
    @GetMapping("/v1/get")
    @ResponseBody
    public PersonDto findPerson(@RequestParam int id) {
        log.info("start to find id: {} ",  id);
        PersonDto person = personService.findOne(id);
        log.info("person found id: {} ",  id);
        return person;
    }
    @Operation(summary="about")
    @PostMapping("/v1/insert")
    public void createPerson(@Valid @RequestBody PersonDto personDto) {
        log.info("start process insert person in controller: {}",  personDto);
        personService.insert(personDto);
        log.info("end process insert person in controller: {}",  personDto);
    }
}
