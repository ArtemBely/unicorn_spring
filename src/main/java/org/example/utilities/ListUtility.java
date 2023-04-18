package org.example.utilities;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.ProductDto;
import org.example.data.entity.ProductEntity;
import org.example.data.mapper.ProductMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@UtilityClass

public class ListUtility {
    private List<ProductDto> productDtoList;
    public List<ProductDto> getDtoList(List<ProductEntity> personEntityList, ProductMapper productMapper) {
        productDtoList = new ArrayList<>();
        for (ProductEntity productEntity : personEntityList) {
            productDtoList.add(productMapper.mapToDto(productEntity));
        }
        return productDtoList;
    }
}
