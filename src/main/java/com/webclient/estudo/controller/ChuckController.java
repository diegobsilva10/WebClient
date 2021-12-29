package com.webclient.estudo.controller;

import com.webclient.estudo.client.ChuckClient;
import com.webclient.estudo.response.ChuckResponse;
import com.webclient.estudo.response.ListCategoriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/jokes")
public class ChuckController {

    @Autowired
    ChuckClient chuckClient;



    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ChuckResponse> getPiadaAleatoria() {
        return chuckClient.findAndAleatorio();
    }


    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ListCategoriesResponse> getListCategories() {
        return chuckClient.getCategories();


    }
}
