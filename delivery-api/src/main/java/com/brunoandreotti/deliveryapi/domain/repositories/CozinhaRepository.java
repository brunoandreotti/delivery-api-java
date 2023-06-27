package com.brunoandreotti.deliveryapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

  Boolean existsByNome(String name);
}
