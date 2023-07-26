package com.brunoandreotti.deliveryapi.domain.dtos.estado;

import com.brunoandreotti.deliveryapi.domain.models.Estado;
import lombok.Data;

@Data
public class EstadoResponseDTO {

  private Long id;

  private String nome;

  public EstadoResponseDTO(Estado estado) {
    this.id = estado.getId();
    this.nome = estado.getNome();
  }
}
