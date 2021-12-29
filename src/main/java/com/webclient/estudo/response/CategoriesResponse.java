package com.webclient.estudo.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//ESSA ANOTAÇÃO PERMITE
// A VISIBILIDADE DOS CAMPOS, SEM ELA, AO FAZER A CHAMADA DA API, O CAMPOS APARECERÃO NULOS
// BUSCAR TODAS AS CATEGORIES

@AllArgsConstructor
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CategoriesResponse {

    private String value;


}

