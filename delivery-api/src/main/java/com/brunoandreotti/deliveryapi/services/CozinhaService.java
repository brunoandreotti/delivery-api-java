package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.brunoandreotti.deliveryapi.domain.dtos.cozinha.CozinhaRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.cozinha.CozinhaResponseDTO;
import com.brunoandreotti.deliveryapi.domain.models.Cozinha;
import com.brunoandreotti.deliveryapi.domain.repositories.CozinhaRepository;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeComConstraintException;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeExistenteException;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeNaoEncontradaException;
import com.brunoandreotti.deliveryapi.utils.ConstantStrings;

@Service
public class CozinhaService {

  private CozinhaRepository cozinhaRepository;

  public CozinhaService(CozinhaRepository cozinhaRepository) {
    this.cozinhaRepository = cozinhaRepository;
  }

  


  public List<CozinhaResponseDTO> findAll() {
    return cozinhaRepository.findAll().stream().map(CozinhaResponseDTO::new).toList();
  }

  public CozinhaResponseDTO findById(Long id) {
    Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

    if (cozinha.isEmpty()) {
      throw new EntidadeNaoEncontradaException(String.format(ConstantStrings.NOT_FOUND_ERR, id));
    }

    return new CozinhaResponseDTO(cozinha.get());
  }

  public CozinhaResponseDTO create(CozinhaRequestDTO cozinhaData) {

    boolean cozinhaAlreadyExists = cozinhaRepository.existsByNome(cozinhaData.getNome());

    if (cozinhaAlreadyExists) {
      throw new EntidadeExistenteException(
          String.format("Cozinha %s já existe", cozinhaData.getNome()));
    }

    Cozinha newCozinha = new Cozinha();

    BeanUtils.copyProperties(cozinhaData, newCozinha);

    Cozinha newSavedCozinha = cozinhaRepository.save(newCozinha);

    return new CozinhaResponseDTO(newSavedCozinha);
  }

  public CozinhaResponseDTO updateById(Long id, CozinhaRequestDTO cozinhaData) {
    Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

    if (cozinha.isEmpty()) {
      throw new EntidadeNaoEncontradaException(String.format(ConstantStrings.NOT_FOUND_ERR, id));
    }

    BeanUtils.copyProperties(cozinhaData, cozinha.get(), "id");

    return new CozinhaResponseDTO(cozinhaRepository.save(cozinha.get()));
  }

  public void deleteById(Long id) {
    Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

    if (cozinha.isEmpty()) {
      throw new EntidadeNaoEncontradaException(String.format(ConstantStrings.NOT_FOUND_ERR, id));
    }

    try {
      cozinhaRepository.delete(cozinha.get());
    } catch (Exception e) {
      throw new EntidadeComConstraintException(String.format(
          "Cozinha %s não pode ser excluída por fazer parte de uma constraint no banco de dados",
          cozinha.get().getNome()));
    }
  }


}
