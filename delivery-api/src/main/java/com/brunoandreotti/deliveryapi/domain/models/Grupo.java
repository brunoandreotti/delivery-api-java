package com.brunoandreotti.deliveryapi.domain.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_grupo")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long Id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany()
    @JoinTable(
            name = "tb_grupo_permissao", // nome da tabela pivo
            joinColumns = @JoinColumn(name = "grupo_id"), //nome da coluna com id da entidade principal
            inverseJoinColumns = @JoinColumn(name = "permissao_id") ////nome da coluna com id da entidade secundária
    )
    private List<Permissao> Permissoes;
}
