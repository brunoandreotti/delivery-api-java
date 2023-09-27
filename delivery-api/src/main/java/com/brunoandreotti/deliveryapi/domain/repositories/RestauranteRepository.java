package com.brunoandreotti.deliveryapi.domain.repositories;

import com.brunoandreotti.deliveryapi.domain.models.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Restaurante;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

  boolean existsByNome(String nome);


}
