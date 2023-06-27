package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.brunoandreotti.deliveryapi.domain.dtos.cozinha.CozinhaRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.cozinha.CozinhaResponseDTO;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;
import com.brunoandreotti.deliveryapi.domain.repositories.CozinhaRepository;

@Service
public class CozinhaService {

  private CozinhaRepository cozinhaRepository;

  public CozinhaService(CozinhaRepository cozinhaRepository) {
    this.cozinhaRepository = cozinhaRepository;
  }


  public List<CozinhaResponseDTO> findAll() {
    return cozinhaRepository.findAll().stream().map(CozinhaResponseDTO::new).toList();
  }

  public CozinhaResponseDTO findById(Long id) {
    Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

    if (cozinha.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    return new CozinhaResponseDTO(cozinha.get());
  }

  public CozinhaResponseDTO create(CozinhaRequestDTO data) {

    Boolean cozinhaAlreadyExists = cozinhaRepository.existsByNome(data.getNome());

    if (cozinhaAlreadyExists) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          String.format("Cozinha %s já existe", data.getNome()));
    }

    Cozinha newCozinha = new Cozinha();

    BeanUtils.copyProperties(data, newCozinha);

    Cozinha newSavedCozinha = cozinhaRepository.save(newCozinha);

    return new CozinhaResponseDTO(newSavedCozinha);
  }
}
