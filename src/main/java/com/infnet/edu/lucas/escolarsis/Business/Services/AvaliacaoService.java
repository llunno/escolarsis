package com.infnet.edu.lucas.escolarsis.Business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Avaliacao;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AvaliacaoRepository;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.DisciplinaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    @Autowired
    private final AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private final DisciplinaRepository disciplinaRepository;
    
    public void avaliar(Aluno aluno, Disciplina disciplina, String comentario, Double nota) {
        
        Professor professorAvaliador = (Professor) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        var avaliacao = Avaliacao.builder()
            .aluno(aluno)
            .disciplina(disciplina)
            .comentario(comentario)
            .nota(nota)
            .professorAvaliador(professorAvaliador)
            .build();

        disciplina.getAvaliacoes().add(avaliacao);
        
        disciplinaRepository.save(disciplina);
        avaliacaoRepository.save(avaliacao);
    }
}
