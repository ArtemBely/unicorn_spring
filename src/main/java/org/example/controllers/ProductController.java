package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.PersonDto;
import org.example.data.dto.ProductDto;
import org.example.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")

public class ProductController {
    private final ProductService productService;
    @Operation(summary="about")
    @PostMapping("/v1/insert")
    public void createPerson(@Valid @RequestBody ProductDto productDto) {
        log.info("start process insert product in controller: {}",  productDto);
        productService.insert(productDto);
        log.info("end process insert product in controller: {}",  productDto);
    }
}
