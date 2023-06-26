package com.brunoandreotti.deliveryapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brunoandreotti.deliveryapi.domain.models.Estado;
import com.brunoandreotti.deliveryapi.domain.repositories.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

  @Autowired
  private EstadoRepository estadoRepository;

  @GetMapping
  public ResponseEntity<List<Estado>> listAll() {

    return ResponseEntity.status(HttpStatus.OK).body(estadoRepository.findAll());
  }
}
