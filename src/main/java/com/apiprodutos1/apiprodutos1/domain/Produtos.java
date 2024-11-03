package com.apiprodutos1.apiprodutos1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Produtos {
    private int id;
    private String nome;
    private double preco;
}
