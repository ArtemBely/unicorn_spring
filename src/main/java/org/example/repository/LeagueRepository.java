package org.example.repository;

import org.example.data.entity.LeagueEntity;
import org.example.data.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeagueRepository extends JpaRepository<LeagueEntity, Integer> {
    @Query("SELECT p FROM PersonEntity p JOIN p.league l")
    List<PersonEntity> getJoinInformation();
}
