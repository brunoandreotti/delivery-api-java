package com.brunoandreotti.deliveryapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brunoandreotti.deliveryapi.domain.dtos.cidade.CidadeRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.cidade.CidadeResponseDTO;
import com.brunoandreotti.deliveryapi.services.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

  @Autowired
  private CidadeService cidadeService;


  @GetMapping()
  public ResponseEntity<List<CidadeResponseDTO>> findAll() {

    return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CidadeResponseDTO> findById(@PathVariable Long id) {

    return ResponseEntity.status(HttpStatus.OK).body(cidadeService.findById(id));
  }

  @PostMapping()
  public ResponseEntity<CidadeResponseDTO> create(@RequestBody CidadeRequestDTO cidade) {

    return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.create(cidade));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CidadeResponseDTO> updateById(@PathVariable Long id,
      @RequestBody CidadeRequestDTO cidade) {

    return ResponseEntity.status(HttpStatus.OK).body(cidadeService.updateById(id, cidade));
  }
}
