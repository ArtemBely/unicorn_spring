package org.example.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.example.data.enums.LeagueEnum;

import javax.persistence.*;
import java.util.List;


@Table(name="league")
@Entity(name="LeagueEntity")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class LeagueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name="LEAGUE", nullable = false)
    private LeagueEnum league;

    @OneToMany(targetEntity = PersonEntity.class, mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonEntity> personEntities;
}
