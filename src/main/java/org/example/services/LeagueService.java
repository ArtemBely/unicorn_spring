package org.example.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.LeagueDto;
import org.example.data.entity.LeagueEntity;
import org.example.data.entity.PersonEntity;
import org.example.data.mapper.LeagueMapper;
import org.example.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor

public class LeagueService {
    private final LeagueRepository leagueRepository;
    private LeagueMapper leagueMapper;
    public void insert(LeagueDto league) {
        log.info("start process insert league in services");
        LeagueEntity leagueEntity = leagueMapper.mapToEntity(league);
        log.info("start process into db {}", leagueEntity);
        leagueRepository.save(leagueEntity);
        log.info("end process insert league in services");
    }
    public List<PersonEntity> joinWithPeople() {
        log.info("DATA is: {}", leagueRepository.getJoinInformation());
        return leagueRepository.getJoinInformation();
    }
}
