package com.infnet.edu.lucas.escolarsis.Domain.Disciplina;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.hibernate.annotations.NaturalId;

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
    @NaturalId
    private String nome;
    private String descricao;
    @ManyToMany
    private Collection<Aluno> alunos;
    @ManyToMany
    private Collection<Professor> professores;
    @OneToMany
    private Collection<Avaliacao> avaliacoes;

    public Collection<Aluno> getAlunosAprovados() {
        
        var alunosAprovados_notaFinal = new HashMap<Aluno,Double>();
        for (var avaliacao : avaliacoes) {
            var aluno = avaliacao.getAluno();
            var nota = avaliacao.getNota();
            if (alunosAprovados_notaFinal.containsKey(aluno)) {
                var notaFinal = alunosAprovados_notaFinal.get(aluno);
                alunosAprovados_notaFinal.put(aluno, notaFinal + nota);
            } else {
                alunosAprovados_notaFinal.put(aluno, nota);
            }
        }
        
        for (var aluno : alunosAprovados_notaFinal.keySet()) {
            var totalAvaliacoes = 0;
            for (var avaliacao : avaliacoes) {
                if (avaliacao.getAluno().equals(aluno)) {
                    totalAvaliacoes++;
                }
            }

            var media = alunosAprovados_notaFinal.get(aluno) / totalAvaliacoes;
            if (media < 7) {
                alunos.remove(aluno);
            }
        }

        return alunosAprovados_notaFinal.keySet();
    }

    public Collection<Aluno> getAlunosReprovados() {
        
        var alunosReprovados_notaFinal = new HashMap<Aluno,Double>();
        for (var avaliacao : avaliacoes) {
            var aluno = avaliacao.getAluno();
            var nota = avaliacao.getNota();
            if (alunosReprovados_notaFinal.containsKey(aluno)) {
                var notaFinal = alunosReprovados_notaFinal.get(aluno);
                alunosReprovados_notaFinal.put(aluno, notaFinal + nota);
            } else {
                alunosReprovados_notaFinal.put(aluno, nota);
            }
        }
        
        for (var aluno : alunosReprovados_notaFinal.keySet()) {
            var totalAvaliacoes = 0;
            for (var avaliacao : avaliacoes) {
                if (avaliacao.getAluno().equals(aluno)) {
                    totalAvaliacoes++;
                }
            }

            var media = alunosReprovados_notaFinal.get(aluno) / totalAvaliacoes;
            if (media >= 7) {
                alunos.remove(aluno);
            }
        }

        return alunosReprovados_notaFinal.keySet();
    }
}
