package com.infnet.edu.lucas.escolarsis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.infnet.edu.lucas.escolarsis.Presentation.Models.DisciplinaResponseModel;

import java.util.UUID;

public class DisciplinaResponseModelTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        UUID codigo = UUID.randomUUID();
        String nome = "Math";
        String descricao = "Mathematics";
        int totalAlunos = 10;
        int totalProfessores = 2;

        // Act
        DisciplinaResponseModel disciplinaResponseModel = new DisciplinaResponseModel(codigo, nome, descricao, totalAlunos, totalProfessores);

        // Assert
        Assertions.assertEquals(codigo, disciplinaResponseModel.codigo());
        Assertions.assertEquals(nome, disciplinaResponseModel.nome());
        Assertions.assertEquals(descricao, disciplinaResponseModel.descricao());
        Assertions.assertEquals(totalAlunos, disciplinaResponseModel.totalAlunos());
        Assertions.assertEquals(totalProfessores, disciplinaResponseModel.totalProfessores());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        UUID codigo1 = UUID.randomUUID();
        String nome1 = "Math";
        String descricao1 = "Mathematics";
        int totalAlunos1 = 10;
        int totalProfessores1 = 2;

        UUID codigo2 = UUID.randomUUID();
        String nome2 = "Science";
        String descricao2 = "Science";
        int totalAlunos2 = 5;
        int totalProfessores2 = 1;

        DisciplinaResponseModel disciplinaResponseModel1 = new DisciplinaResponseModel(codigo1, nome1, descricao1, totalAlunos1, totalProfessores1);
        DisciplinaResponseModel disciplinaResponseModel2 = new DisciplinaResponseModel(codigo1, nome1, descricao1, totalAlunos1, totalProfessores1);
        DisciplinaResponseModel disciplinaResponseModel3 = new DisciplinaResponseModel(codigo2, nome2, descricao2, totalAlunos2, totalProfessores2);

        // Assert
        Assertions.assertEquals(disciplinaResponseModel1, disciplinaResponseModel2);
        Assertions.assertNotEquals(disciplinaResponseModel1, disciplinaResponseModel3);
        Assertions.assertEquals(disciplinaResponseModel1.hashCode(), disciplinaResponseModel2.hashCode());
        Assertions.assertNotEquals(disciplinaResponseModel1.hashCode(), disciplinaResponseModel3.hashCode());
    }

    @Test
    public void testToString() {
        // Arrange
        UUID codigo = UUID.randomUUID();
        String nome = "Math";
        String descricao = "Mathematics";
        int totalAlunos = 10;
        int totalProfessores = 2;

        DisciplinaResponseModel disciplinaResponseModel = new DisciplinaResponseModel(codigo, nome, descricao, totalAlunos, totalProfessores);

        // Assert
        Assertions.assertEquals("DisciplinaResponseModel[codigo=" + codigo + ", nome=Math, descricao=Mathematics, totalAlunos=10, totalProfessores=2]", disciplinaResponseModel.toString());
    }
}