package com.brunoandreotti.deliveryapi.domain.dtos.restaurante;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class RestauranteRequestDTO {

  private String nome;

  private BigDecimal taxaFrete;

  private String cozinha;
}
