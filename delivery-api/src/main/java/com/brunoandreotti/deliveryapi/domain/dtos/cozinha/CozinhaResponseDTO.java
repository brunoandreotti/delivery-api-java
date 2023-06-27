package com.brunoandreotti.deliveryapi.domain.dtos.cozinha;

import com.brunoandreotti.deliveryapi.domain.models.Cozinha;
import lombok.Data;

@Data
public class CozinhaResponseDTO {

  private Long id;

  private String nome;

  public CozinhaResponseDTO(Cozinha cozinha) {
    this.id = cozinha.getId();
    this.nome = cozinha.getNome();
  }
}
