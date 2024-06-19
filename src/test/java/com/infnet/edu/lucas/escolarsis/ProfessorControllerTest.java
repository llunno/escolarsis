package com.infnet.edu.lucas.escolarsis;

import com.infnet.edu.lucas.escolarsis.Business.Services.AvaliacaoService;
import com.infnet.edu.lucas.escolarsis.Business.Services.ProfessorService;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Avaliacao;
import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Aluno;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Presentation.Controllers.ProfessorController;
import com.infnet.edu.lucas.escolarsis.Presentation.Models.AvaliarAlunoRequestModel;
import com.infnet.edu.lucas.escolarsis.utils.AlunoMapper;
import com.infnet.edu.lucas.escolarsis.utils.DisciplinaMapper;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.AvaliacaoRepository;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.DisciplinaRepository;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.ProfessorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.instancio.Instancio;
import org.instancio.Select;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfessorControllerTest {

    @Autowired
    private ProfessorController professorController;
    @Mock
    private ProfessorService professorService;
    @Mock
    private ProfessorRepository ProfessorRepository;
    @Mock
    private AlunoMapper alunoMapper;
    @Mock
    private DisciplinaMapper disciplinaMapper;
    @Mock
    private DisciplinaRepository disciplinaRepository;
    @Mock
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private AvaliacaoService avaliacaoService;

    @Test
    public void testCreate() {
        // Arrange
        Professor professor = Instancio.create(Professor.class);
        doNothing().when(professorService).create(professor);

        ReflectionTestUtils.setField(professorController, "professorService", professorService);

        // Act
        professorController.create(professor);


        // Assert
        verify(professorService).create(professor);
    }

    @Test
    @WithMockUser(
        username = "professor",
        password = "password",
        roles = "PROFESSOR"
    )
    public void testAvaliarAluno() {

        // Arrange
        var alunoSample = Instancio.create(Aluno.class);
        var disciplinaSample = Instancio.create(Disciplina.class);

        String alunoId = "1";
        String disciplina = "Math";
        String comentario = "Good job!";
        Double nota = 9.0;
        
        AvaliarAlunoRequestModel request = Instancio.of(AvaliarAlunoRequestModel.class)
        .set(Select.field("alunoId"), alunoId)
        .set(Select.field("disciplina"), disciplina)
        .set(Select.field("nota"), nota)
        .set(Select.field("comentario"), comentario)
        .create();

        when(alunoMapper.fromIdToAluno(alunoId)).thenReturn(alunoSample);
        when(disciplinaMapper.toEntity(disciplina)).thenReturn(disciplinaSample);
        when(ProfessorRepository.findByUsernameAndPassword("professor", "password")).thenReturn(Optional.of(Instancio.create(Professor.class)));
        when(disciplinaRepository.save(disciplinaSample)).thenReturn(disciplinaSample);
        when(avaliacaoRepository.save(Instancio.create(Avaliacao.class))).thenReturn(Instancio.create(Avaliacao.class));

        ReflectionTestUtils.setField(professorController, "alunoMapper", alunoMapper);
        ReflectionTestUtils.setField(professorController, "disciplinaMapper", disciplinaMapper);
        ReflectionTestUtils.setField(avaliacaoService, "professorRepository", ProfessorRepository);
        ReflectionTestUtils.setField(avaliacaoService, "disciplinaRepository", disciplinaRepository);
        ReflectionTestUtils.setField(avaliacaoService, "avaliacaoRepository", avaliacaoRepository);

        // Act
        professorController.avaliarAluno(request);

        // Assert
        verify(alunoMapper).fromIdToAluno(alunoId);
        verify(disciplinaMapper).toEntity(disciplina);
    }
}