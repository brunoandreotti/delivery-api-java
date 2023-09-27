package com.brunoandreotti.deliveryapi.domain.models;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "tb_forma_pagamento")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FormaPagamento {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  private String descricao;

  @ManyToMany(mappedBy = "formasPagamento") // propriedade em que o relacionamento foi feito na entidade Restaurante
  private List<Restaurante> restaurantes;
  
}
