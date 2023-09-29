package com.brunoandreotti.deliveryapi.domain.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable //Classe incorporável, pode ser incorporado à outra entidade, a tabela da entidade terá os dados dessa classe
// juntamente com os dados da própria classe. Indica que é uma parte de outra entidade
public class Endereco {

    @Column(name = "endereco_cep")
    private String cep;

    @Column(name = "endereco_logradouro")
    private String logradouro;

    @Column(name = "endereco_numero")
    private String numero;

    @Column(name = "endereco_complemento")
    private String complemento;

    @Column(name = "endereco_bairro")
    private String bairro;


    @ManyToOne
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;
}
