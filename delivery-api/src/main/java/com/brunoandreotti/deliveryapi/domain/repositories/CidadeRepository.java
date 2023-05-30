package com.brunoandreotti.deliveryapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
