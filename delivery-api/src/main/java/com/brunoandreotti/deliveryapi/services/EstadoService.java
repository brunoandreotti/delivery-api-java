package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.brunoandreotti.deliveryapi.domain.dtos.estado.EstadoResponseDTO;
import com.brunoandreotti.deliveryapi.domain.repositories.EstadoRepository;

@Service
public class EstadoService {

  private EstadoRepository estadoRepository;

  public EstadoService(EstadoRepository estadoRepository) {
    this.estadoRepository = estadoRepository;
  }

  public List<EstadoResponseDTO> findAll() {
    return estadoRepository.findAll().stream().map(EstadoResponseDTO::new).toList();
  }

}
