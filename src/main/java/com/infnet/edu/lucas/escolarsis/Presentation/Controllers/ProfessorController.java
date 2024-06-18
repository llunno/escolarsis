package com.infnet.edu.lucas.escolarsis.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.edu.lucas.escolarsis.Business.Services.AvaliacaoService;
import com.infnet.edu.lucas.escolarsis.Business.Services.ProfessorService;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.AvaliarAlunoRequestModel;
import com.infnet.edu.lucas.escolarsis.utils.AlunoMapper;
import com.infnet.edu.lucas.escolarsis.utils.DisciplinaMapper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private AvaliacaoService avaliacaoService;
    @Autowired
    private AlunoMapper alunoMapper;
    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @PostMapping("/create")
    public void create(@RequestBody Professor entity) {
        professorService.create(entity);
    }

    @PostMapping("/avaliar-aluno")
    public void avaliarAluno(@RequestBody AvaliarAlunoRequestModel request) {
        var aluno = alunoMapper.fromIdToAluno(request.alunoId());
        var disciplina = disciplinaMapper.toEntity(request.disciplina());
        avaliacaoService.avaliar(aluno, disciplina, request.comentario(), request.nota());
    }
}
