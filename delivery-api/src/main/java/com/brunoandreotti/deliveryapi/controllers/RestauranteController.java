package com.brunoandreotti.deliveryapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brunoandreotti.deliveryapi.domain.dtos.restaurante.RestauranteRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.restaurante.RestauranteResponseDTO;
import com.brunoandreotti.deliveryapi.services.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

  @Autowired
  private RestauranteService restauranteService;



  @GetMapping()
  public ResponseEntity<List<RestauranteResponseDTO>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(restauranteService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<RestauranteResponseDTO> findById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(restauranteService.findById(id));

  }

  @PostMapping()
  public ResponseEntity<RestauranteResponseDTO> create(
      @RequestBody RestauranteRequestDTO restaurante) {
    return ResponseEntity.status(HttpStatus.CREATED).body(restauranteService.create(restaurante));
  }

  @PutMapping("/{id}")
  public ResponseEntity<RestauranteResponseDTO> updateById(@PathVariable Long id,
      @RequestBody RestauranteRequestDTO restaurante) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(restauranteService.updateById(id, restaurante));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    restauranteService.deleteById(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }



}
