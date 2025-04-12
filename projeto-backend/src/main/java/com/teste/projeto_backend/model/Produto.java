package com.teste.projeto_backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Produto {

    private Integer id;

    private String nome;

    private Integer quantidade;

    private Double valor;

    private String observacao;
    
}

