package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.brunoandreotti.deliveryapi.domain.dtos.restaurante.RestauranteRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.restaurante.RestauranteResponseDTO;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;
import com.brunoandreotti.deliveryapi.domain.models.Restaurante;
import com.brunoandreotti.deliveryapi.domain.repositories.CozinhaRepository;
import com.brunoandreotti.deliveryapi.domain.repositories.RestauranteRepository;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeExistenteException;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeNaoEncontradaException;
import com.brunoandreotti.deliveryapi.utils.ConstantStrings;

@Service
public class RestauranteService {

  private RestauranteRepository restauranteRepository;
  private CozinhaRepository cozinhaRepository;

  public RestauranteService(RestauranteRepository restauranteRepository,
      CozinhaRepository cozinhaRepository) {
    this.restauranteRepository = restauranteRepository;
    this.cozinhaRepository = cozinhaRepository;
  }

  public List<RestauranteResponseDTO> findAll() {
    return restauranteRepository.findAll().stream().map(RestauranteResponseDTO::new).toList();
  }

  public RestauranteResponseDTO findById(Long id) {
    Optional<Restaurante> restaurante = restauranteRepository.findById(id);

    if (restaurante.isEmpty()) {
      throw new EntidadeNaoEncontradaException(String.format(ConstantStrings.NOT_FOUND_ID_ERR, id));
    }

    return new RestauranteResponseDTO(restaurante.get());
  }

  public RestauranteResponseDTO create(RestauranteRequestDTO restaurante) {

    validateCreateRestaurante(restaurante);

    Cozinha cozinha = cozinhaRepository.findByNome(restaurante.getCozinha());

    Restaurante newRestaurante = new Restaurante();

    BeanUtils.copyProperties(restaurante, newRestaurante);

    newRestaurante.setCozinha(cozinha);

    Restaurante savedRestaurante = restauranteRepository.save(newRestaurante);

    return new RestauranteResponseDTO(savedRestaurante);

  }

  public RestauranteResponseDTO updateById(Long id, RestauranteRequestDTO restauranteData) {
    Optional<Restaurante> restauranteExists = restauranteRepository.findById(id);
    Optional<Cozinha> cozinhaExists = cozinhaRepository.optionalFindByNome(restauranteData.getCozinha());

    if (restauranteExists.isEmpty()) {
      throw new EntidadeNaoEncontradaException(String.format(ConstantStrings.NOT_FOUND_ID_ERR, id));
    }

    if (cozinhaExists.isEmpty()) {
      throw new EntidadeNaoEncontradaException(
          String.format(ConstantStrings.NOT_FOUND_NAME_ERR, restauranteData.getCozinha()));
    }

    BeanUtils.copyProperties(restauranteData, restauranteExists.get(), "id");

    restauranteExists.get().setCozinha(cozinhaExists.get());

    return new RestauranteResponseDTO(restauranteRepository.save(restauranteExists.get()));


  }

  public void deleteById(Long id) {
    Optional<Restaurante> restauranteExists = restauranteRepository.findById(id);

    if(restauranteExists.isEmpty()) {
      throw new EntidadeNaoEncontradaException(
          String.format(ConstantStrings.NOT_FOUND_ID_ERR, id));
    }

    restauranteRepository.deleteById(id);
  }

  private void validateCreateRestaurante(RestauranteRequestDTO restaurante) {

    boolean restauranteAlreadyExists = restauranteRepository.existsByNome(restaurante.getNome());
    boolean cozinhaAlreadyExists = cozinhaRepository.existsByNome(restaurante.getCozinha());

    if (restauranteAlreadyExists) {
      throw new EntidadeExistenteException(
          String.format(ConstantStrings.EXISTING_ENTITY, restaurante.getNome()));
    }

    if (!cozinhaAlreadyExists) {
      throw new EntidadeNaoEncontradaException(
          String.format(ConstantStrings.NOT_FOUND_NAME_ERR, restaurante.getCozinha()));
    }
  }
  


}
