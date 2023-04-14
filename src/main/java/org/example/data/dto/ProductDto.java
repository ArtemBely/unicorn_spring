package org.example.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.example.data.enums.StateEnum;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductDto {
    private int id;
    @Valid
    @Size(min=2, message="Product should contain more than 2 character")
    private String content;
    private StateEnum state;
    @PositiveOrZero
    @Max(130)
    private int count;
}
