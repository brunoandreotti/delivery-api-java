package com.brunoandreotti.deliveryapi.domain.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

  Optional<Estado> findByNome(String nome);
  boolean existsByNome(String nome);
}
