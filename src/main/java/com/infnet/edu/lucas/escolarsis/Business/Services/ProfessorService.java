package com.infnet.edu.lucas.escolarsis.Business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public void create(Professor entity) {
        professorRepository.save(entity);
    }
}
