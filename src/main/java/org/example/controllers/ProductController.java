package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.data.dto.ProductDto;
import org.example.exceptions.ProductException;
import org.example.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")

public class ProductController {
    private final ProductService productService;

    @GetMapping("/v1/all")
    @ResponseBody
    public List<ProductDto> findAllProducts() {
        log.info("start to find products");
        List<ProductDto> productList = productService.findAll();
        log.info("products founded ...");
        return productList;
    }

    @GetMapping("/v1/get")
    @ResponseBody
    public ProductDto findProduct(@RequestParam int id) {
        try {
            log.info("start to find id: {} ",  id);
            ProductDto product = productService.findOne(id);
            log.info("product found id: {} ",  id);
            return product;
        }
        catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    @GetMapping("/v1/get/byname")
    @ResponseBody
    public List<ProductDto> findPerson(@RequestParam String content) {
        log.info("start to find product: {} ",  content);
        List<ProductDto> product = productService.findOneByName(content);
        log.info("end to find product: {}", content);
        return product;
    }

    @GetMapping("/v1/getItems")
    @ResponseBody
    public List<ProductDto> findAllProducts(@RequestParam String state) {
        try{
            log.info("start to find products");
            List<ProductDto> productList = productService.findState(state);
            log.info("products founded ...");
            return productList;
        }
        catch (ProductException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Product Not Found", ex);
        }
    }

    @Operation(summary="about")
    @PostMapping("/v1/insert")
    public void createProductn(@Valid @RequestBody ProductDto productDto) {
        log.info("start process insert product in controller: {}",  productDto);
        productService.insert(productDto);
        log.info("end process insert product in controller: {}",  productDto);
    }

    @PutMapping("/v1/change")
    public void changeProduct(@Valid @RequestBody ProductDto productDto, @RequestParam int id) {
        try {
            log.info("Start of processing of finding product with id = {}", id);
            ProductDto product = productService.findOne(id);
            productService.changeOne(productDto, id);
            log.info("Product with id = {}, is = {}", id, product);
        }
        catch (Exception e) {
            log.error(e.toString());
        }
    }

    @DeleteMapping("/v1/delete")
    @ResponseBody
    public String deleteProduct(@RequestParam int id) {
        log.info("start process of deleting product id: {}", id);
        productService.deleteOne(id);
        return "Deleted successfully";
    }
}
