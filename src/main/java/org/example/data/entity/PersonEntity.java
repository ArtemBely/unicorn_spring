package org.example.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Table(name="unicorn_person")
@Entity(name="PersonEntity")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)


public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    private int id;

    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name="LAST_NAME", nullable = false)
    private String lastName;

    @Column(name="AGE", nullable = false)
    private int age;

    //how to do it in another way without extra field?
//    @Column(name="league_id", nullable = false)
//    private int league_id;

    @ManyToOne
    //@JoinColumn(name = "league_id", referencedColumnName="ID", updatable = false)
    @JoinColumn(name = "league_id", referencedColumnName="ID", updatable = false)
    private LeagueEntity league;
}
