package com.brunoandreotti.deliveryapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;
import com.brunoandreotti.deliveryapi.domain.repositories.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

  @Autowired
  private CozinhaRepository cozinhaRepository;

  @GetMapping
  public ResponseEntity<List<Cozinha>> listAll() {
    return ResponseEntity.status(HttpStatus.OK).body(cozinhaRepository.findAll());


  }

  @GetMapping("/{id}")
  public ResponseEntity<Cozinha> listById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(cozinhaRepository.findById(id).get());


  }
}
