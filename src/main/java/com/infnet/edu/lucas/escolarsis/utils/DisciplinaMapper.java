package com.infnet.edu.lucas.escolarsis.utils;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.DisciplinaRepository;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.DisciplinaResponseModel;

@Mapper(componentModel = "spring")
public abstract class DisciplinaMapper {
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina toEntity(String nome) {
        return disciplinaRepository.findByNome(nome).orElse(null);
    }

    @Mapping(target = "totalAlunos", expression = "java(mapTotals(disciplina.getAlunos()))")
    @Mapping(target = "totalProfessores", expression = "java(mapTotals(disciplina.getProfessores()))")
    public abstract DisciplinaResponseModel toResponseModel(Disciplina disciplina);

    public int mapTotals(Collection<?> alunos) {
        return alunos.size();
    }
}
