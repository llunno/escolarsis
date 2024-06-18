package com.infnet.edu.lucas.escolarsis.Domain.Disciplina;

import java.util.Collection;
import java.util.UUID;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name = "disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codigo;
    private String nome;
    private String descricao;
    @ManyToMany
    private Collection<Aluno> alunos;
    @ManyToMany
    private Collection<Professor> professores;
    @OneToMany
    private Collection<Avaliacao> avaliacoes;
}
