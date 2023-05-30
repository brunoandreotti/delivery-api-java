package com.brunoandreotti.deliveryapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Restaurante;


public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
