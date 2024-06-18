package com.infnet.edu.lucas.escolarsis.Domain.Usuários;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoas")
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID matricula;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
