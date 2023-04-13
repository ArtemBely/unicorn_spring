package org.example.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Table(name="product")
@Entity(name="ProductEntity")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    private int id;

    @Column(name="CONTENT", nullable = false)
    private String content;

    @Column(name="STATE", nullable = false)
    private String state;

    @Column(name="COUNT", nullable = false)
    private int count;
}
