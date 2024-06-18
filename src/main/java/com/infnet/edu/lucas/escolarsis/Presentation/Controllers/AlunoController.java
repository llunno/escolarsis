package com.infnet.edu.lucas.escolarsis.Presentation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.edu.lucas.escolarsis.Business.Services.AlunoService;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.utils.AlunoMapper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private AlunoMapper alunoMapper;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Aluno entity) {
        alunoService.create(entity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        var alunos = alunoService.getAll();
        var alunosResponse = alunos.stream().map(alunoMapper::toAlunoResponseModel).toList();
        return ResponseEntity.ok(alunosResponse);
    }
}
