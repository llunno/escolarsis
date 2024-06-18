package com.infnet.edu.lucas.escolarsis.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.edu.lucas.escolarsis.Business.Services.DisciplinaService;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.utils.AlunoMapper;
import com.infnet.edu.lucas.escolarsis.utils.DisciplinaMapper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;
    @Autowired
    private DisciplinaMapper disciplinaMapper;
    @Autowired
    private AlunoMapper alunoMapper;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Disciplina entity) {
        disciplinaService.create(entity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        var disciplinas = disciplinaService.getAll();
        var disciplinasResponse = disciplinas.stream().map(disciplinaMapper::toResponseModel).toList();
        return ResponseEntity.ok(disciplinasResponse);
    }

    @GetMapping("/aprovados")
    public ResponseEntity<?> aprovados(@RequestBody String disciplina) {
        var disciplinaEntity = disciplinaMapper.toEntity(disciplina);
        var alunos = disciplinaEntity.getAlunosAprovados();
        var alunosResponse = alunos.stream().map(alunoMapper::toAlunoResponseModel).toList();
        return ResponseEntity.ok(alunosResponse);
    }

    @GetMapping("/reprovados")
    public ResponseEntity<?> reprovados(@RequestBody String disciplina) {
        var disciplinaEntity = disciplinaMapper.toEntity(disciplina);
        var alunos = disciplinaEntity.getAlunosReprovados();
        var alunosResponse = alunos.stream().map(alunoMapper::toAlunoResponseModel).toList();
        return ResponseEntity.ok(alunosResponse);
    }
}
