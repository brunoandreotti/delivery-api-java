package com.brunoandreotti.deliveryapi.controllers;

import com.brunoandreotti.deliveryapi.domain.dtos.formaPagamento.FormaPagamentoResponseDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.restaurante.RestauranteResponseDTO;
import com.brunoandreotti.deliveryapi.services.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("forma-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;


    @GetMapping()
    public ResponseEntity<List<FormaPagamentoResponseDTO>> findAll(@RequestParam(required = false) String restaurante) {
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamentoService.findByRestaurant(restaurante));
    }
}
