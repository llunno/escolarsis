package com.infnet.edu.lucas.escolarsis.Business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Avaliacao;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AvaliacaoRepository;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.DisciplinaRepository;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    @Autowired
    private final AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private final DisciplinaRepository disciplinaRepository;
    @Autowired
    private final ProfessorRepository professorRepository;
    
    public void avaliar(Aluno aluno, Disciplina disciplina, String comentario, Double nota) {
        
        User authenticationUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Professor professorAvaliador = professorRepository.findByUsernameAndPassword(authenticationUser.getUsername(), authenticationUser.getPassword()).get();


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
