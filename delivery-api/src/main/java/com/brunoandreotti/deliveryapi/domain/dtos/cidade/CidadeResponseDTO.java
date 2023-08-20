package com.brunoandreotti.deliveryapi.domain.dtos.cidade;

import com.brunoandreotti.deliveryapi.domain.models.Cidade;
import lombok.Data;

@Data
public class CidadeResponseDTO {

  Long id;

  String nome;

  String estado;

  public CidadeResponseDTO(Cidade cidade) {
    this.id = cidade.getId();
    this.nome = cidade.getNome();
    this.estado = cidade.getEstado().getNome();
  }
}
