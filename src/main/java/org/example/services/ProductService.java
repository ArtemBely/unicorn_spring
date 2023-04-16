package org.example.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.example.data.dto.ProductDto;
import org.example.data.entity.ProductEntity;
import org.example.data.enums.StateEnum;
import org.example.data.mapper.ProductMapper;
import org.example.exceptions.ProductException;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private List<ProductDto> productDtoList;

    public List<ProductDto> findAll() {
        log.info("Find all products");
        productDtoList = new ArrayList<>();
        List<ProductEntity> personEntityList = productRepository.findAll();
        for (ProductEntity productEntity : personEntityList) {
            productDtoList.add(productMapper.mapToDto(productEntity));
        }
        return productDtoList;
    }

    public List<ProductDto> findState(String state) throws ProductException {
        log.info("Find all products");
        productDtoList = new ArrayList<>();
        if(EnumUtils.isValidEnum(StateEnum.class, state)) {
            List<ProductEntity> personEntityList = productRepository
                    .findAll()
                    .stream()
                    .filter( item -> item.getState().toString().equals(state) )
                    .collect(Collectors.toList());
            for (ProductEntity productEntity : personEntityList) {
                productDtoList.add(productMapper.mapToDto(productEntity));
            }
            return productDtoList;
        }
        else throw new ProductException("Not compatible type of filter");
    }

    public List<ProductDto> findOneByName(String content) {
        log.info("Find certain person");
        List<ProductDto> personDto = new ArrayList<>();
        List<ProductEntity> productOptionalEntity = productRepository.findByAlternative(content);
        for(ProductEntity entity : productOptionalEntity) {
            personDto.add(productMapper.mapToDto(entity));
        }
        return personDto;
    }

    public ProductDto findOne(int id) throws ProductException {
        log.info("Find certain person");
        if(id != 0) {
            Optional<ProductEntity> personEntityOptional = productRepository.findById(id); // see
            ProductDto productDto = productMapper.mapToDto(personEntityOptional.get());
            return productDto;
        }
        else throw new ProductException("No id was accepted");
    }
    public void insert(ProductDto dto) {
        log.info("start process insert product in services");
        ProductEntity productEntity = productMapper.mapToEntity(dto);
        log.info("start process into db {}", productEntity);
        productRepository.save(productEntity);
        log.info("end process insert product in services");
    }
    public void changeOne(ProductDto dto, int id) {
        log.info("start process of changing product in services");
        ProductEntity productEntity = productMapper.mapToEntity(dto);
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        ProductEntity changedProduct = productEntityOptional.get();
        if (productEntity.getContent() != null && !Objects.equals(productEntity.getContent(), changedProduct.getContent())) {
            changedProduct.setContent(productEntity.getContent());
        }
        if(productEntity.getCount() != 0 && productEntity.getCount() != changedProduct.getCount()) {
            changedProduct.setCount(productEntity.getCount());
        }
        if(productEntity.getState() != null && EnumUtils.isValidEnum(StateEnum.class, changedProduct.getState().toString())) {
            changedProduct.setState(productEntity.getState());
        }
        log.info("start process into db {}", productEntity);
        productRepository.save(changedProduct);
        log.info("end process of changing product in services");
    }

    public void deleteOne(int id) {
        log.info("start process delete product from services");
        productRepository.deleteById(id);
    }
}
