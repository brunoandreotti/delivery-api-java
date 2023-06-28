package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.brunoandreotti.deliveryapi.domain.dtos.restaurante.RestauranteResponseDTO;
import com.brunoandreotti.deliveryapi.domain.models.Restaurante;
import com.brunoandreotti.deliveryapi.domain.repositories.RestauranteRepository;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeNaoEncontradaException;
import com.brunoandreotti.deliveryapi.utils.ConstantStrings;

@Service
public class RestauranteService {

  private RestauranteRepository restauranteRepository;

  public RestauranteService(RestauranteRepository restauranteRepository) {
    this.restauranteRepository = restauranteRepository;
  }

  public List<RestauranteResponseDTO> findAll() {
    return restauranteRepository.findAll().stream().map(RestauranteResponseDTO::new).toList();
  }

  public RestauranteResponseDTO findById(Long id) {
    Optional<Restaurante> restaurante = restauranteRepository.findById(id);

    if (restaurante.isEmpty()) {
      throw new EntidadeNaoEncontradaException(String.format(ConstantStrings.NOT_FOUND_ERR, id));
    }

    return new RestauranteResponseDTO(restaurante.get());
  }
}
