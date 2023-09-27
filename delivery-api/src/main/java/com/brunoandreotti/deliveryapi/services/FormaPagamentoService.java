package com.brunoandreotti.deliveryapi.services;

import com.brunoandreotti.deliveryapi.domain.dtos.formaPagamento.FormaPagamentoResponseDTO;
import com.brunoandreotti.deliveryapi.domain.repositories.FormaPagamentoRepository;
import com.brunoandreotti.deliveryapi.domain.repositories.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;
    private final RestauranteRepository restauranteRepository;

    public FormaPagamentoService(FormaPagamentoRepository formaPagamentoRepository, RestauranteRepository restauranteRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
        this.restauranteRepository = restauranteRepository;
    }


    public List<FormaPagamentoResponseDTO> findByRestaurant(String restaurante) {
        if (restaurante == null) {
            return formaPagamentoRepository.findAll().stream().map(FormaPagamentoResponseDTO::new).toList();
        }
        return formaPagamentoRepository.findFormaPagamento(restaurante).stream().map(FormaPagamentoResponseDTO::new).toList();
    }
}
