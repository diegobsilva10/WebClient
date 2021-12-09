package com.webclient.estudo.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//ESSA ANOTAÇÃO PERMITE
// A VISIBILIDADE DOS CAMPOS, SEM ELA, AO FAZER A CHAMADA DA API, O CAMPOS APARECERÃO NULOS
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChuckResponse {
    private String created_at;
    private String icon_url;
    private String id;
    private String updated_at;
    private String url;
    private String value;
}


