package com.brunoandreotti.deliveryapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Entidade com constraint no banco de dados")
public class EntidadeComConstraintException extends RuntimeException {

  public EntidadeComConstraintException(String mensagem) {
    super(mensagem);
  }
}
