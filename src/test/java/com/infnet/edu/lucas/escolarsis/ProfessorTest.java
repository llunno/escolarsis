package com.infnet.edu.lucas.escolarsis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProfessorTest {

    private Professor professor;

    @Mock
    private UserDetails userDetails;

    @BeforeEach
    public void setup() {
        professor = new Professor();
        professor.setNome("John Doe");
        professor.setFormacao("Ph.D. in Computer Science");
        professor.setCargos(List.of("ROLE_TEACHER"));
        professor.setSenha("password");
        professor.setDisciplinas(new ArrayList<>());
    }

    @Test
    public void testGetAuthorities() {
        // Arrange
        Collection<? extends GrantedAuthority> expectedAuthorities = List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));

        // Act
        Collection<? extends GrantedAuthority> actualAuthorities = professor.getAuthorities();

        // Assert
        assertEquals(expectedAuthorities, actualAuthorities);
    }

    @Test
    public void testGetPassword() {
        // Arrange
        String expectedPassword = "password";

        // Act
        String actualPassword = professor.getPassword();

        // Assert
        assertEquals(expectedPassword, actualPassword);
    }

    @Test
    public void testGetUsername() {
        // Arrange
        String expectedUsername = "John Doe";

        // Act
        String actualUsername = professor.getUsername();

        // Assert
        assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void testGetFormacao() {
        // Arrange
        String expectedFormacao = "Ph.D. in Computer Science";

        // Act
        String actualFormacao = professor.getFormacao();

        // Assert
        assertEquals(expectedFormacao, actualFormacao);
    }

    @Test
    public void testGetCargos() {
        // Arrange
        List<String> expectedCargos = List.of("ROLE_TEACHER");

        // Act
        List<String> actualCargos = professor.getCargos();

        // Assert
        assertEquals(expectedCargos, actualCargos);
    }

    @Test
    public void testGetDisciplinas() {
        // Arrange
        Collection<Disciplina> expectedDisciplinas = new ArrayList<>();

        // Act
        Collection<Disciplina> actualDisciplinas = professor.getDisciplinas();

        // Assert
        assertEquals(expectedDisciplinas, actualDisciplinas);
    }

    @Test
    public void testSetFormacao() {
        // Arrange
        String expectedFormacao = "M.Sc. in Computer Science";

        // Act
        professor.setFormacao(expectedFormacao);
        String actualFormacao = professor.getFormacao();

        // Assert
        assertEquals(expectedFormacao, actualFormacao);
    }

    @Test
    public void testSetCargos() {
        // Arrange
        List<String> expectedCargos = List.of("ROLE_TEACHER", "ROLE_ADMIN");

        // Act
        professor.setCargos(expectedCargos);
        List<String> actualCargos = professor.getCargos();

        // Assert
        assertEquals(expectedCargos, actualCargos);
    }

    @Test
    public void testSetDisciplinas() {
        // Arrange
        Collection<Disciplina> expectedDisciplinas = new ArrayList<>();
        Disciplina disciplina1 = new Disciplina();
        Disciplina disciplina2 = new Disciplina();
        expectedDisciplinas.add(disciplina1);
        expectedDisciplinas.add(disciplina2);

        // Act
        professor.setDisciplinas(expectedDisciplinas);
        Collection<Disciplina> actualDisciplinas = professor.getDisciplinas();

        // Assert
        assertEquals(expectedDisciplinas, actualDisciplinas);
    }
}