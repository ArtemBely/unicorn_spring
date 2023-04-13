package org.example.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.ProductDto;
import org.example.data.entity.ProductEntity;
import org.example.data.mapper.ProductMapper;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    public void insert(ProductDto dto) {
        log.info("start process insert product in services");
        ProductEntity productEntity = productMapper.mapToEntity(dto);
        log.info("start process into db {}", productEntity);
        productRepository.save(productEntity);
        log.info("end process insert product in services");
    }
}
