package com.infnet.edu.lucas.escolarsis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.infnet.edu.lucas.escolarsis.Presentation.Models.AvaliarAlunoRequestModel;

public class AvaliarAlunoRequestModelTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String alunoId = "123";
        String disciplina = "Math";
        String comentario = "Good job!";
        Double nota = 9.5;

        // Act
        AvaliarAlunoRequestModel model = new AvaliarAlunoRequestModel(alunoId, disciplina, comentario, nota);

        // Assert
        Assertions.assertEquals(alunoId, model.alunoId());
        Assertions.assertEquals(disciplina, model.disciplina());
        Assertions.assertEquals(comentario, model.comentario());
        Assertions.assertEquals(nota, model.nota());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        AvaliarAlunoRequestModel model1 = new AvaliarAlunoRequestModel("123", "Math", "Good job!", 9.5);
        AvaliarAlunoRequestModel model2 = new AvaliarAlunoRequestModel("123", "Math", "Good job!", 9.5);
        AvaliarAlunoRequestModel model3 = new AvaliarAlunoRequestModel("456", "Science", "Well done!", 8.0);

        // Assert
        Assertions.assertEquals(model1, model2);
        Assertions.assertNotEquals(model1, model3);
        Assertions.assertEquals(model1.hashCode(), model2.hashCode());
        Assertions.assertNotEquals(model1.hashCode(), model3.hashCode());
    }
}