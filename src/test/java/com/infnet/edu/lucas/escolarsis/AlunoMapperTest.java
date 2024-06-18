package com.infnet.edu.lucas.escolarsis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Endereco;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AlunoRepository;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.AlunoResponseModel;
import com.infnet.edu.lucas.escolarsis.utils.AlunoMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class AlunoMapperTest {

    @Autowired
    private AlunoMapper alunoMapper;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    public void setup() {
        alunoMapper = Mappers.getMapper(AlunoMapper.class);
    }

    @Test
    public void testToAlunoResponseModel() {
        // Arrange
        Aluno aluno = new Aluno();
        aluno.setMatricula(UUID.randomUUID());
        aluno.setNome("John Doe");
        aluno.setEmail("john.doe@example.com");

        Endereco endereco = new Endereco();
        endereco.setCep("12345-678");
        endereco.setLogradouro("Rua dos Bobos");
        endereco.setBairro("Centro");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setComplemento("Apto 101");
        endereco.setNumero("123");
        aluno.setEndereco(endereco);

        // Act
        AlunoResponseModel responseModel = alunoMapper.toAlunoResponseModel(aluno);

        // Assert
        assertEquals(aluno.getNome(), responseModel.nome());
        assertEquals(aluno.getEmail(), responseModel.email());
    }

    @Test
    public void testFromIdToAluno() {
        // Arrange
        String id = UUID.randomUUID().toString();
        Aluno expectedAluno = new Aluno();
        when(alunoRepository.findById(UUID.fromString(id))).thenReturn(Optional.of(expectedAluno));
        ReflectionTestUtils.setField(alunoMapper, "alunoRepository", alunoRepository);
        
        // Act
        Aluno result = alunoMapper.fromIdToAluno(id);

        // Assert
        assertEquals(expectedAluno, result);
    }

    public String mapEnderecoToStringdEndereco(Endereco endereco) {
        return endereco.toString();
    }
}