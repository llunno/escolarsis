package com.infnet.edu.lucas.escolarsis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.DisciplinaRepository;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.DisciplinaResponseModel;
import com.infnet.edu.lucas.escolarsis.utils.DisciplinaMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class DisciplinaMapperTest {

    @Autowired
    private DisciplinaMapper disciplinaMapper;

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @BeforeEach
    public void setup() {
        disciplinaMapper = Mappers.getMapper(DisciplinaMapper.class);
    }

    @Test
    public void testToEntity() {
        // Arrange
        String nome = "Math";

        Disciplina expectedDisciplina = new Disciplina();
        expectedDisciplina.setNome(nome);

        when(disciplinaRepository.findByNome(nome)).thenReturn(Optional.of(expectedDisciplina));
        ReflectionTestUtils.setField(disciplinaMapper, "disciplinaRepository", disciplinaRepository);

        // Act
        Disciplina result = disciplinaMapper.toEntity(nome);

        // Assert
        assertEquals(expectedDisciplina, result);
    }

    @Test
    public void testToResponseModel() {
        // Arrange
        var disciplina = Instancio.create(Disciplina.class);

        // Act
        DisciplinaResponseModel responseModel = disciplinaMapper.toResponseModel(disciplina);

        // Assert
        assertEquals(disciplina.getAlunos().size(), responseModel.totalAlunos());
        assertEquals(disciplina.getProfessores().size(), responseModel.totalProfessores());
    }

    @Test
    public void testMapTotals() {
        // Arrange
        Collection<Object> collection = new ArrayList<>();
        collection.add(new Object());
        collection.add(new Object());
        collection.add(new Object());

        // Act
        int result = disciplinaMapper.mapTotals(collection);

        // Assert
        assertEquals(collection.size(), result);
    }
}