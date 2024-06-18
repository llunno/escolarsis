package com.infnet.edu.lucas.escolarsis.utils;

import org.mapstruct.Mapper;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;

@Mapper(componentModel = "spring")
public interface DisciplinaNomeToEntityMapper {

    public Disciplina toEntity(String nome); 
}
