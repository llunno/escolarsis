package com.infnet.edu.lucas.escolarsis.Business.Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.DisciplinaRepository;
import com.infnet.edu.lucas.escolarsis.utils.EntityHandlerMethods;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DisciplinaService implements EntityHandlerMethods<Disciplina> {

    @Autowired
    private final DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina create(Disciplina entity) {
        return disciplinaRepository.save(entity);
    }

    @Override
    public Collection<Disciplina> getAll() {
        return disciplinaRepository.findAll();
    }

    public Collection<Aluno> getAprovadosByDisciplina(Disciplina disciplina) {
        return disciplina.getAlunosAprovados();
    }

    public Collection<Aluno> getReprovadosByDisciplina(Disciplina disciplina) {
        return disciplina.getAlunosReprovados();
    }
}
