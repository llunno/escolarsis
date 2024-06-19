package com.infnet.edu.lucas.escolarsis;

import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;

import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AlunoTest {

    private Collection<Disciplina> disciplinas = Instancio.createList(Disciplina.class);

    private Aluno aluno;

    @BeforeEach
    public void setup() {
        aluno = new Aluno();
        aluno.setDisciplinas(disciplinas);
    }

    @Test
    public void testGetDisciplinas() {
        // Arrange
        Collection<Disciplina> expectedDisciplinas = disciplinas;

        // Act
        Collection<Disciplina> actualDisciplinas = aluno.getDisciplinas();

        // Assert
        assertEquals(expectedDisciplinas, actualDisciplinas);
    }

    @Test
    public void testSetDisciplinas() {
        // Arrange
        Collection<Disciplina> expectedDisciplinas = disciplinas;

        // Act
        aluno.setDisciplinas(expectedDisciplinas);

        // Assert
        assertEquals(expectedDisciplinas, aluno.getDisciplinas());
    }

    @Test
    public void testAddDisciplina() {
        // Arrange
        Disciplina disciplina = new Disciplina();
        
        // Act
        aluno.getDisciplinas().add(disciplina);
        
        // Assert
        assertTrue(aluno.getDisciplinas().contains(disciplina));
    }

    @Test
    public void testRemoveDisciplina() {
        // Arrange
        Disciplina disciplina = new Disciplina();
        aluno.getDisciplinas().add(disciplina);
        
        // Act
        aluno.getDisciplinas().remove(disciplina);
        
        // Assert
        assertFalse(aluno.getDisciplinas().contains(disciplina));
    }

    @Test
    public void testGetDisciplinasSize() {
        // Arrange
        int expectedSize = disciplinas.size();
        
        // Act
        int actualSize = aluno.getDisciplinas().size();
        
        // Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddDisciplinaDuplicate() {
        // Arrange
        Disciplina disciplina = new Disciplina();
        aluno.getDisciplinas().add(disciplina);

        // Act
        boolean addedFirstTime = aluno.getDisciplinas().add(disciplina);
        boolean addedSecondTime = aluno.getDisciplinas().add(disciplina);

        // Assert
        assertTrue(addedFirstTime);
        assertTrue(addedSecondTime);
    }

    @Test
    public void testRemoveDisciplinaNonexistent() {
        // Arrange
        Disciplina disciplina = new Disciplina();

        // Act
        boolean removed = aluno.getDisciplinas().remove(disciplina);

        // Assert
        assertFalse(removed);
    }

    @Test
    public void testGetDisciplinasEmpty() {
        // Arrange
        aluno.getDisciplinas().clear();

        // Act
        int actualSize = aluno.getDisciplinas().size();

        // Assert
        assertEquals(0, actualSize);
    }
}