package com.brunoandreotti.deliveryapi.domain.models;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_restaurante")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private BigDecimal taxaFrete;

  @ManyToOne
  @JoinColumn(name = "cozinha_id", nullable = false) // Coluna na tb_restaurante que conterá o id da cozinha
  private Cozinha cozinha;

  @ManyToMany
  @JoinTable( // é na entidade principal que o relacionamento é configurado
          name = "restaurante_forma_pagamento", //nome da tabela pivô
          joinColumns = @JoinColumn(name = "restaurante_id"), //nome da coluna com id da entidade principal
          inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id") //nome da coluna com o id da entidade secundária
  )
  private List<FormaPagamento> formasPagamento;

}
