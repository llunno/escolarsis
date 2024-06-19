package com.infnet.edu.lucas.escolarsis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Avaliacao;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AvaliacaoTest {

    private Avaliacao avaliacao;

    @Mock
    private Aluno aluno;
    @Mock
    private Disciplina disciplina;
    @Mock
    private Professor professorAvaliador;

    @BeforeEach
    public void setup() {
        avaliacao = Avaliacao.builder()
                .id(UUID.randomUUID())
                .aluno(aluno)
                .disciplina(disciplina)
                .nota(8.5)
                .professorAvaliador(professorAvaliador)
                .comentario("Good job!")
                .build();
    }

    @Test
    public void testGetId() {
        // Arrange
        UUID expectedId = avaliacao.getId();

        // Act
        UUID actualId = avaliacao.getId();

        // Assert
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetAluno() {
        // Arrange
        Aluno expectedAluno = aluno;

        // Act
        Aluno actualAluno = avaliacao.getAluno();

        // Assert
        assertEquals(expectedAluno, actualAluno);
    }

    @Test
    public void testGetDisciplina() {
        // Arrange
        Disciplina expectedDisciplina = disciplina;

        // Act
        Disciplina actualDisciplina = avaliacao.getDisciplina();

        // Assert
        assertEquals(expectedDisciplina, actualDisciplina);
    }

    @Test
    public void testGetNota() {
        // Arrange
        Double expectedNota = 8.5;

        // Act
        Double actualNota = avaliacao.getNota();

        // Assert
        assertEquals(expectedNota, actualNota);
    }

    @Test
    public void testGetProfessorAvaliador() {
        // Arrange
        Professor expectedProfessorAvaliador = professorAvaliador;

        // Act
        Professor actualProfessorAvaliador = avaliacao.getProfessorAvaliador();

        // Assert
        assertEquals(expectedProfessorAvaliador, actualProfessorAvaliador);
    }

    @Test
    public void testGetComentario() {
        // Arrange
        String expectedComentario = "Good job!";

        // Act
        String actualComentario = avaliacao.getComentario();

        // Assert
        assertEquals(expectedComentario, actualComentario);
    }
}