package com.webclient.estudo.client;

import com.webclient.estudo.response.CategoriesResponse;
import com.webclient.estudo.response.ChuckResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Service
@Slf4j
public class ChuckClient {


  //  WebClient client = WebClient.create("https://api.chucknorris.io");

    private final WebClient webClient;

    public ChuckClient(WebClient.Builder builder){
        webClient = builder.baseUrl("https://api.chucknorris.io").build();
    }

    //PALAVRA MONO: SERVE PARA TRATAR APENAS UM DADO SÓ, OU SEJA,
    // QUANDO A REQUISIÇÃO FOR FEITA POR UM DADO ESPECIFICO, UTILIZA O MONO
    public Mono<ChuckResponse> findAndAleatorio(){
        log.info("Buscando uma piada aleatória");
        return webClient
                .get()
                .uri("/jokes/random")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique paramettros informados")))
                .bodyToMono(ChuckResponse.class);
    }

    public Mono<CategoriesResponse> findAndCategories(){
        log.info("Buscando categorias");
        return webClient
                .get()
                .uri("/jokes/categories")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique paramettros informados")))
                .bodyToMono(CategoriesResponse.class);
    }
}


