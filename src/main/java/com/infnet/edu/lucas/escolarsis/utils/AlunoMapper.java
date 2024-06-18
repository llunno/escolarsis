package com.infnet.edu.lucas.escolarsis.utils;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AlunoRepository;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.AlunoResponseModel;

@Mapper(componentModel = "spring")
public abstract class AlunoMapper {

    @Autowired
    private AlunoRepository alunoRepository;

    public abstract AlunoResponseModel toAlunoResponseModel(Aluno aluno);
    
    public Aluno fromIdToAluno(String id) {
        return alunoRepository.findById(UUID.fromString(id)).orElse(null);
    }
}
