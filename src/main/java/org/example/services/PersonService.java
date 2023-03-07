package org.example.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.PersonDto;
import org.example.data.entity.PersonEntity;
import org.example.data.mapper.PersonMapper;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor


public class PersonService {
    private PersonMapper personMapper;
    private final PersonRepository personRepository;

    public PersonDto findOne(int id) {
        log.info("Find certain person");
        Optional<PersonEntity> personOptionalEntity = personRepository.findById(id); // see
        PersonDto personDto = personMapper.mapToDto(personOptionalEntity.get());
        return personDto;
    }
    public void insert(PersonDto dto) {
        log.info("start process insert person in services");
        PersonEntity personEntity = personMapper.mapToEntity(dto);
        log.info("start process into db {}", personEntity);
        personRepository.save(personEntity);
        log.info("end process insert person in services");
    }
}
