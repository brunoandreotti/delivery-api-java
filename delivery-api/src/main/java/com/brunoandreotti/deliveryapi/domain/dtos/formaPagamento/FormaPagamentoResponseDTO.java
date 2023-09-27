package com.brunoandreotti.deliveryapi.domain.dtos.formaPagamento;

import com.brunoandreotti.deliveryapi.domain.models.FormaPagamento;
import lombok.Data;

@Data
public class FormaPagamentoResponseDTO {
    private Long id;

    private String descricao;

    public FormaPagamentoResponseDTO(FormaPagamento formaPagamento) {
        this.id = formaPagamento.getId();
        this.descricao = formaPagamento.getDescricao();
    }
}
