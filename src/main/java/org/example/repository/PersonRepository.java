package org.example.repository;
import org.example.data.entity.LeagueEntity;
import org.example.data.entity.PersonEntity;
import org.example.data.enums.LeagueEnum;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
