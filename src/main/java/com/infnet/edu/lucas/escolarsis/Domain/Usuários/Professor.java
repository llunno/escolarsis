package com.infnet.edu.lucas.escolarsis.Domain.Usuários;

import java.util.Collection;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "professores")
public class Professor extends Pessoa {
    
    private String formacao;
    private String senha;
    @ManyToMany(mappedBy = "professores")
    private Collection<Disciplina> disciplinas;
}
