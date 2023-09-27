package com.brunoandreotti.deliveryapi.domain.dtos.cozinha;

import com.brunoandreotti.deliveryapi.domain.models.Cozinha;
import com.brunoandreotti.deliveryapi.domain.models.Restaurante;
import lombok.Data;

import java.util.List;

@Data
public class CozinhaResponseDTO {

  private Long id;

  private String nome;

  private List<String> restaurantes;

  public CozinhaResponseDTO(Cozinha cozinha) {
    this.id = cozinha.getId();
    this.nome = cozinha.getNome();
    this.restaurantes = cozinha.getRestaurantes().stream().map(Restaurante::getNome).toList();
  }
}
