package com.infnet.edu.lucas.escolarsis;

import com.infnet.edu.lucas.escolarsis.Business.Services.ProfessorService;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.ProfessorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProfessorServiceTest {

    @Autowired
    private ProfessorService professorService;

    @Mock
    private ProfessorRepository professorRepository;

    @BeforeEach
    public void setup() {
        professorService = new ProfessorService(professorRepository);
    }

    @Test
    public void testCreate() {
        // Arrange
        Professor professor = new Professor();

        // Act
        professorService.create(professor);

        // Assert
        verify(professorRepository, times(1)).save(professor);
    }

    @Test
    public void testLoadUserByUsername_ExistingUser() {
        // Arrange
        String username = "john";
        Professor professor = new Professor();
        when(professorRepository.findByNome(username)).thenReturn(Optional.of(professor));

        // Act
        Professor result = (Professor) professorService.loadUserByUsername(username);

        // Assert
        assertEquals(professor, result);
    }

    @Test
    public void testLoadUserByUsername_NonExistingUser() {
        // Arrange
        String username = "jane";
        when(professorRepository.findByNome(username)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UsernameNotFoundException.class, () -> professorService.loadUserByUsername(username));
    }
}