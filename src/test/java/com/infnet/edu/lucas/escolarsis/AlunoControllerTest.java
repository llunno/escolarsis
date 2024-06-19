package com.infnet.edu.lucas.escolarsis;

import com.infnet.edu.lucas.escolarsis.Business.Services.AlunoService;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Presentation.Controllers.AlunoController;
import com.infnet.edu.lucas.escolarsis.utils.AlunoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AlunoControllerTest {

    @Autowired
    private AlunoController alunoController;

    @Mock
    private AlunoService alunoService;
    @Mock
    private AlunoMapper alunoMapper;

    @BeforeEach
    public void setup() {
        alunoController = new AlunoController(alunoService, alunoMapper);
    }

    @Test
    public void testCreate() {
        // Arrange
        Aluno aluno = new Aluno();
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();

        // Act
        ResponseEntity<?> actualResponse = alunoController.create(aluno);

        // Assert
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
    }

    @Test
    public void testAll() {
        // Arrange
        List<Aluno> alunos = new ArrayList<>();
        when(alunoService.getAll()).thenReturn(alunos);
        ResponseEntity<List<?>> expectedResponse = ResponseEntity.ok(alunos);

        // Act
        ResponseEntity<?> actualResponse = alunoController.all();

        // Assert
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }
}