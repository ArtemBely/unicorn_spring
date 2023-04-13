package org.example.data.mapper;

import lombok.AllArgsConstructor;
import org.example.data.dto.ProductDto;
import org.example.data.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductMapper {
    private final ModelMapper modelMapper;
    public ProductEntity mapToEntity(ProductDto dto){
        return modelMapper.map(dto, ProductEntity.class).toBuilder().build();
    }
    public ProductDto mapToDto(ProductEntity entity){
        return modelMapper.map(entity, ProductDto.class).toBuilder().build();
    }
}