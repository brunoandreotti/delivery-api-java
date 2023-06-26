package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;
import com.brunoandreotti.deliveryapi.domain.repositories.CozinhaRepository;

@Service
public class CozinhaService {

  private CozinhaRepository cozinhaRepository;

  public CozinhaService(CozinhaRepository cozinhaRepository) {
    this.cozinhaRepository = cozinhaRepository;
  }


  public List<Cozinha> findAll() {
    return cozinhaRepository.findAll();
  }

  public Cozinha findById(Long id) {
    Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

    if (cozinha.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    return cozinha.get();
  }
}
