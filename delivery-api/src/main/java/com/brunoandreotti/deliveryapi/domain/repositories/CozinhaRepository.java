package com.brunoandreotti.deliveryapi.domain.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

  boolean existsByNome(String name);

  @Query("SELECT c FROM Cozinha c WHERE c.nome = :nome")
  Optional<Cozinha> optionalFindByNome(String nome);


  Cozinha findByNome(String nome);

}
