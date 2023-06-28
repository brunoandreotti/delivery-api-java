package com.brunoandreotti.deliveryapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Entidade já existente no banco de dados")
public class EntidadeExistenteException extends RuntimeException {

  public EntidadeExistenteException(String mensagem) {
    super(mensagem);
  }
}
