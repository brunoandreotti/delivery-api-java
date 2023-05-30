package com.brunoandreotti.deliveryapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brunoandreotti.deliveryapi.domain.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
