package com.infnet.edu.lucas.escolarsis;

import com.infnet.edu.lucas.escolarsis.Business.Services.DisciplinaService;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Presentation.Controllers.DisciplinaController;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.AlunoResponseModel;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.DisciplinaResponseModel;
import com.infnet.edu.lucas.escolarsis.utils.AlunoMapper;
import com.infnet.edu.lucas.escolarsis.utils.DisciplinaMapper;

import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DisciplinaControllerTest {

    @Autowired
    private DisciplinaController disciplinaController;

    @Mock
    private DisciplinaService disciplinaService;
    @Mock
    private DisciplinaMapper disciplinaMapper;
    @Mock
    private AlunoMapper alunoMapper;

    @BeforeEach
    public void setup() {
        disciplinaController = new DisciplinaController(disciplinaService, disciplinaMapper, alunoMapper);
    }

    @Test
    public void testCreate() {
        // Arrange
        Disciplina disciplina = new Disciplina();
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();

        // Act
        ResponseEntity<?> actualResponse = disciplinaController.create(disciplina);

        // Assert
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    public void testAll() {
        
        // Arrange
        List<Disciplina> disciplinas = Instancio.createList(Disciplina.class);
        when(disciplinaService.getAll()).thenReturn(disciplinas);
        List<DisciplinaResponseModel> disciplinasResponse = disciplinas.stream().map(disciplinaMapper::toResponseModel).toList();
        ResponseEntity<?> expectedResponse = ResponseEntity.ok(disciplinasResponse);

        // Act
        ResponseEntity<?> actualResponse = disciplinaController.all();

        // Assert
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }

    @Test
    public void testAprovados() {
        // Arrange
        String disciplina = "disciplina";
        
        Collection<Aluno> alunos = Instancio.createList(Aluno.class);
        Disciplina disciplinaEntity = Instancio.of(Disciplina.class)
        .set(Select.field("alunos"), alunos)
        .create();
        
        when(disciplinaMapper.toEntity(disciplina)).thenReturn(disciplinaEntity);
        
        List<AlunoResponseModel> alunosResponse = alunos.stream().map(alunoMapper::toAlunoResponseModel).toList();
        ResponseEntity<?> expectedResponse = ResponseEntity.ok(alunosResponse);

        // Act
        ResponseEntity<?> actualResponse = disciplinaController.aprovados(disciplina);

        // Assert
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    public void testReprovados() {
        // Arrange
        String disciplina = "disciplina";
        
        Collection<Aluno> alunos = Instancio.createList(Aluno.class);
        Disciplina disciplinaEntity = Instancio.of(Disciplina.class)
        .set(Select.field("alunos"), alunos)
        .create();
        
        when(disciplinaMapper.toEntity(disciplina)).thenReturn(disciplinaEntity);
        
        List<AlunoResponseModel> alunosResponse = alunos.stream().map(alunoMapper::toAlunoResponseModel).toList();
        ResponseEntity<?> expectedResponse = ResponseEntity.ok(alunosResponse);

        // Act
        ResponseEntity<?> actualResponse = disciplinaController.reprovados(disciplina);

        // Assert
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }
}