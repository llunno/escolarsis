package com.infnet.edu.lucas.escolarsis.Domain.Usuários;

import java.util.Collection;
import java.util.UUID;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "alunos")
public class Aluno extends Pessoa {

    private Boolean aprovado;
    @ManyToMany(mappedBy = "alunos")
    private Collection<Disciplina> disciplinas;
}
