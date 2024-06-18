package com.infnet.edu.lucas.escolarsis.utils;

import org.mapstruct.Mapper;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.DisciplinaResponseModel;

@Mapper(componentModel = "spring")
public interface DisciplinaMapper {
    
    public Disciplina toEntity(String nome);

    public DisciplinaResponseModel toResponseModel(Disciplina disciplina);
}
