package com.webclient.estudo.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//ESSA ANOTAÇÃO PERMITE
// A VISIBILIDADE DOS CAMPOS, SEM ELA, AO FAZER A CHAMADA DA API, O CAMPOS APARECERÃO NULOS
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChuckResponse {

    private String value;
}


