package com.infnet.edu.lucas.escolarsis.Domain.Usuários;

import java.util.Collection;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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

    @ManyToMany(mappedBy = "alunos")
    @NotEmpty
    private Collection<Disciplina> disciplinas;
}
