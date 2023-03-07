package org.example.data.mapper;

import lombok.AllArgsConstructor;
import org.example.data.dto.PersonDto;
import org.example.data.entity.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PersonMapper {
    private final ModelMapper modelMapper;
    public PersonEntity mapToEntity(PersonDto dto){
        return modelMapper.map(dto, PersonEntity.class).toBuilder().build();
    }
    public PersonDto mapToDto(PersonEntity entity){
        return modelMapper.map(entity, PersonDto.class).toBuilder().build();
    }
}
