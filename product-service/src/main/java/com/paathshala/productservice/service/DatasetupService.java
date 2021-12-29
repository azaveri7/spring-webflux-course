package com.paathshala.productservice.service;

import com.paathshala.productservice.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DatasetupService implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        ProductDto p1 = new ProductDto("Yonex Astrox", 2099);
        ProductDto p2 = new ProductDto("Bitwin Bicycle", 12999);
        ProductDto p3 = new ProductDto("Samsung Galaxy S5", 19999);
        ProductDto p4 = new ProductDto("Sony Headphones", 799);

        Flux.just(p1, p2, p3, p4)
                .flatMap(p -> this.productService.insertProduct(Mono.just(p)))
                .subscribe(System.out::println);

    }
}
