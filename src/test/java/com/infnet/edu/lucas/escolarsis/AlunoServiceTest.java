package com.infnet.edu.lucas.escolarsis;

import com.infnet.edu.lucas.escolarsis.Business.Services.AlunoService;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AlunoServiceTest {

    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    public void setup() {
        alunoService = new AlunoService(alunoRepository);
    }

    @Test
    public void testCreate() {
        // Arrange
        Aluno aluno = new Aluno();
        when(alunoRepository.save(aluno)).thenReturn(aluno);

        // Act
        Aluno createdAluno = alunoService.create(aluno);

        // Assert
        assertEquals(aluno, createdAluno);
        verify(alunoRepository, times(1)).save(aluno);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<Aluno> alunos = new ArrayList<>();
        when(alunoRepository.findAll()).thenReturn(alunos);

        // Act
        Collection<Aluno> allAlunos = alunoService.getAll();

        // Assert
        assertEquals(alunos, allAlunos);
        verify(alunoRepository, times(1)).findAll();
    }
}