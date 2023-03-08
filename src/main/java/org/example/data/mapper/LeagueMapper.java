package org.example.data.mapper;

import lombok.AllArgsConstructor;
import org.example.data.dto.LeagueDto;
import org.example.data.entity.LeagueEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component

public class LeagueMapper {
    private final ModelMapper modelMapper;
    public LeagueEntity mapToEntity(LeagueDto dto){
        return modelMapper.map(dto, LeagueEntity.class).toBuilder().build();
    }
    public LeagueDto mapToDto(LeagueEntity entity){
        return modelMapper.map(entity, LeagueDto.class).toBuilder().build();
    }
}
