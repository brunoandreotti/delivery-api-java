package com.brunoandreotti.deliveryapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
