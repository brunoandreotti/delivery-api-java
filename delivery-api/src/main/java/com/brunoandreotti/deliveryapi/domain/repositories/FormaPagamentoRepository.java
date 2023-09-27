package com.brunoandreotti.deliveryapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.FormaPagamento;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Optional;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

    @Query(value = "select\n" +
            "  tfp.id,\n" +
            "  tfp.descricao\n" +
            "from\n" +
            "  restaurante_forma_pagamento rfp\n" +
            "  inner join tb_restaurante tr on rfp.restaurante_id = tr.id\n" +
            "  inner join tb_forma_pagamento tfp on rfp.forma_pagamento_id = tfp.id\n" +
            "where\n" +
            " tr.nome = :restaurante",
            nativeQuery = true)
    List<FormaPagamento> findFormaPagamento(String restaurante);
}
