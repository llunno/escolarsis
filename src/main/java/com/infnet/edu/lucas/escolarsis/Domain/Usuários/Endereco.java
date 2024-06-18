package com.infnet.edu.lucas.escolarsis.Domain.Usuários;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String numero;
    private String pais = "Brasil";
    @OneToMany(mappedBy = "endereco")
    private Collection<Pessoa> pessoas;
}
