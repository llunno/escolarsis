package com.infnet.edu.lucas.escolarsis;

import com.infnet.edu.lucas.escolarsis.Business.Services.DisciplinaService;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.DisciplinaRepository;

import org.h2.command.query.Select;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DisciplinaServiceTest {

    @Autowired
    private DisciplinaService disciplinaService;

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @BeforeEach
    public void setup() {
        disciplinaService = new DisciplinaService(disciplinaRepository);
    }

    @Test
    public void testCreate() {
        // Arrange
        Disciplina disciplina = new Disciplina();
        Disciplina expectedDisciplina = new Disciplina();
        when(disciplinaRepository.save(disciplina)).thenReturn(expectedDisciplina);

        // Act
        Disciplina actualDisciplina = disciplinaService.create(disciplina);

        // Assert
        assertEquals(expectedDisciplina, actualDisciplina);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<Disciplina> disciplinas = new ArrayList<>();
        when(disciplinaRepository.findAll()).thenReturn(disciplinas);

        // Act
        Collection<Disciplina> actualDisciplinas = disciplinaService.getAll();

        // Assert
        assertEquals(disciplinas, actualDisciplinas);
    }

    @Test
    public void testGetAprovadosByDisciplina() {
        // Arrange
        Collection<Aluno> expectedAlunos = Instancio.createList(Aluno.class);
        Disciplina disciplina = Instancio.of(Disciplina.class).set(org.instancio.Select.field("alunos"), expectedAlunos).create();

        // Act
        Collection<Aluno> actualAlunos = disciplinaService.getAprovadosByDisciplina(disciplina);

        // Assert
        System.out.println(actualAlunos);
    }

    @Test
    public void testGetReprovadosByDisciplina() {
        // Arrange
        Collection<Aluno> expectedAlunos = Instancio.createList(Aluno.class);
        Disciplina disciplina = Instancio.of(Disciplina.class).set(org.instancio.Select.field("alunos"), expectedAlunos).create();

        // Act
        Collection<Aluno> actualAlunos = disciplinaService.getReprovadosByDisciplina(disciplina);

        // Assert
        System.out.println(actualAlunos);
    }
}