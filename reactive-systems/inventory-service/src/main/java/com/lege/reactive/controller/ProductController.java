package com.lege.reactive.controller;

import com.lege.domain.Product;
import com.lege.reactive.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author lege
 * @Description
 * @create 2022-09-06 15:08
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public Flux<Product> getAllProducts() {
        log.info("Get all products invoked.");
        return productService.getProducts();
    }

}
