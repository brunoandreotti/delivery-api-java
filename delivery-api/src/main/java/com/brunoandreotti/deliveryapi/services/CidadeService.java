package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.brunoandreotti.deliveryapi.domain.dtos.cidade.CidadeRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.cidade.CidadeResponseDTO;
import com.brunoandreotti.deliveryapi.domain.models.Cidade;
import com.brunoandreotti.deliveryapi.domain.models.Estado;
import com.brunoandreotti.deliveryapi.domain.repositories.CidadeRepository;
import com.brunoandreotti.deliveryapi.domain.repositories.EstadoRepository;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeExistenteException;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeNaoEncontradaException;
import com.brunoandreotti.deliveryapi.utils.ConstantStrings;

@Service
public class CidadeService {

  private CidadeRepository cidadeRepository;

  private EstadoRepository estadoRepository;

  public CidadeService(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
    this.cidadeRepository = cidadeRepository;
    this.estadoRepository = estadoRepository;
  }

  public List<CidadeResponseDTO> findAll() {
    return cidadeRepository.findAll().stream().map(CidadeResponseDTO::new).toList();
  }

  public CidadeResponseDTO findById(Long id) {
    Cidade cidade =
        cidadeRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
            String.format(ConstantStrings.NOT_FOUND_ID_ERR, id)));

    return new CidadeResponseDTO(cidade);
  }

  public CidadeResponseDTO create(CidadeRequestDTO cidadeData) {

    boolean cidadeAlreadyExists = cidadeRepository.existsByNome(cidadeData.getNome());

    if (cidadeAlreadyExists) {
      throw new EntidadeExistenteException(
          String.format(ConstantStrings.EXISTING_ENTITY, cidadeData.getNome()));
    }

    Estado estado = estadoRepository.findByNome(cidadeData.getEstado())
        .orElseThrow(() -> new EntidadeNaoEncontradaException(
            String.format(ConstantStrings.NOT_FOUND_NAME_ERR, cidadeData.getEstado())));

    Cidade newCidade = new Cidade();

    BeanUtils.copyProperties(cidadeData, newCidade);

    newCidade.setEstado(estado);

    Cidade savedCidade = cidadeRepository.save(newCidade);

    return new CidadeResponseDTO(savedCidade);
  }

  public CidadeResponseDTO updateById(Long id, CidadeRequestDTO cidadeData) {

    Cidade cidadeById =
        cidadeRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
            String.format(ConstantStrings.NOT_FOUND_ID_ERR, id)));

    boolean cidadeByNome = cidadeRepository.existsByNome(cidadeData.getNome());

    if (cidadeByNome) {
      throw new EntidadeExistenteException(
          String.format(ConstantStrings.EXISTING_ENTITY, cidadeData.getNome()));
    }

    boolean estadoByNome = estadoRepository.existsByNome(cidadeData.getEstado());

    if (!estadoByNome) {
      throw new EntidadeNaoEncontradaException(
          String.format(ConstantStrings.NOT_FOUND_NAME_ERR, cidadeData.getEstado()));
    }

    BeanUtils.copyProperties(cidadeData, cidadeById, "id");

    Cidade updatedCidade = cidadeRepository.save(cidadeById);

    return new CidadeResponseDTO(updatedCidade);
  }


}
