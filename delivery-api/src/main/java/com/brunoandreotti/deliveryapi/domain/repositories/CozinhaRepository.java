package com.brunoandreotti.deliveryapi.domain.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

  boolean existsByNome(String name);
  Optional<Cozinha> findByNome(String nome);

}
