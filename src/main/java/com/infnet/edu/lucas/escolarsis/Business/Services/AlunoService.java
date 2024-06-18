package com.infnet.edu.lucas.escolarsis.Business.Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AlunoRepository;
import com.infnet.edu.lucas.escolarsis.utils.EntityHandlerMethods;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService implements EntityHandlerMethods<Aluno> {

    @Autowired
    private final AlunoRepository alunoRepository;

    @Override
    public Aluno create(Aluno entity) {
        return alunoRepository.save(entity);
    }

    @Override
    public Collection<Aluno> getAll() {
        return alunoRepository.findAll();
    }
}
