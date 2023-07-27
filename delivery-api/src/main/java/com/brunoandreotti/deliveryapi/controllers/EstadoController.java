package com.brunoandreotti.deliveryapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brunoandreotti.deliveryapi.domain.dtos.estado.EstadoRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.estado.EstadoResponseDTO;
import com.brunoandreotti.deliveryapi.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

  @Autowired
  private EstadoService estadoService;

  @GetMapping
  public ResponseEntity<List<EstadoResponseDTO>> findAll() {

    return ResponseEntity.status(HttpStatus.OK).body(estadoService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<EstadoResponseDTO> findById(@PathVariable Long id) {

    return ResponseEntity.status(HttpStatus.OK).body(estadoService.findById(id));
  }

  @PostMapping
  public ResponseEntity<EstadoResponseDTO> create(@RequestBody EstadoRequestDTO estado) {

    return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.create(estado));
  }
}
