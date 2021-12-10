package com.webclient.estudo.client;

import com.webclient.estudo.response.CategoriesResponse;
import com.webclient.estudo.response.ChuckResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.asMediaType;


@Service
@Slf4j
public class ChuckClient {


    WebClient client = WebClient.create("https://api.chucknorris.io/jokes");

   // private final WebClient webClient;

   // public ChuckClient(WebClient.Builder builder){
   //     webClient = builder.baseUrl("https://api.chucknorris.io").build();
    //}

    //PALAVRA MONO: SERVE PARA TRATAR APENAS UM DADO SÓ, OU SEJA,
    // QUANDO A REQUISIÇÃO FOR FEITA POR UM DADO ESPECIFICO, UTILIZA O MONO
    public Mono<ChuckResponse> findAndAleatorio(){
        log.info("Buscando uma piada aleatória");
        return client
                .get()
                .uri("/random")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique parametros informados")))
                .bodyToMono(ChuckResponse.class);
    }

    public Mono<CategoriesResponse> findAndCategories(){
        log.info("Buscando categorias");
        return client
                .get()
                .uri("/categories")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique parametros informados")))
                .bodyToMono(CategoriesResponse.class);
    }
}


