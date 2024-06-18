package com.infnet.edu.lucas.escolarsis.Business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Avaliacao;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AvaliacaoRepository;
import com.infnet.edu.lucas.escolarsis.utils.DisciplinaNomeToEntityMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    @Autowired
    private final AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private final SecurityContext securityContext;
    @Autowired
    private final DisciplinaNomeToEntityMapper disciplinaNomeToEntityMapper; 

    public void avaliar(Aluno aluno, String disciplina, String comentario, Double nota) {
        Professor professorAvaliador = (Professor) securityContext.getAuthentication().getPrincipal();
        var avaliacao = Avaliacao.builder()
            .aluno(aluno)
            .disciplina(disciplinaNomeToEntityMapper.toEntity(disciplina))
            .comentario(comentario)
            .nota(nota)
            .professorAvaliador(professorAvaliador)
            .build();

        avaliacaoRepository.save(avaliacao);
    }
}