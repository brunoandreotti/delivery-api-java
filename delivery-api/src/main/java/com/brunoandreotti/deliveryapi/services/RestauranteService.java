package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.brunoandreotti.deliveryapi.domain.dtos.restaurante.RestauranteResponseDTO;
import com.brunoandreotti.deliveryapi.domain.repositories.RestauranteRepository;

@Service
public class RestauranteService {

  private RestauranteRepository restauranteRepository;

  public RestauranteService(RestauranteRepository restauranteRepository) {
    this.restauranteRepository = restauranteRepository;
  }

  public List<RestauranteResponseDTO> findAll() {
    return restauranteRepository.findAll().stream().map(RestauranteResponseDTO::new).toList();
  }
}
