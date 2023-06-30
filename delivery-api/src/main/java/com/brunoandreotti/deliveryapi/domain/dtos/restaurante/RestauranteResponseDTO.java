package com.brunoandreotti.deliveryapi.domain.dtos.restaurante;

import java.math.BigDecimal;
import com.brunoandreotti.deliveryapi.domain.models.Restaurante;
import lombok.Data;

@Data
public class RestauranteResponseDTO {

  private Long id;

  private String nome;

  private BigDecimal taxaFrete;

  private String cozinha;

  public RestauranteResponseDTO(Restaurante restaurante) {
    this.id = restaurante.getId();
    this.nome = restaurante.getNome();
    this.taxaFrete = restaurante.getTaxaFrete();
    this.cozinha = restaurante.getCozinha().getNome();
  }
}
