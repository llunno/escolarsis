package com.infnet.edu.lucas.escolarsis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.infnet.edu.lucas.escolarsis.Presentation.Models.AlunoResponseModel;

public class AlunoResponseModelTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String matricula = "123456";
        String nome = "John Doe";
        String email = "john.doe@example.com";
        String cpf = "123456789";
        String telefone = "1234567890";
        String endereco = "123 Main St";

        // Act
        AlunoResponseModel aluno = new AlunoResponseModel(matricula, nome, email, cpf, telefone, endereco);

        // Assert
        Assertions.assertEquals(matricula, aluno.matricula());
        Assertions.assertEquals(nome, aluno.nome());
        Assertions.assertEquals(email, aluno.email());
        Assertions.assertEquals(cpf, aluno.cpf());
        Assertions.assertEquals(telefone, aluno.telefone());
        Assertions.assertEquals(endereco, aluno.endereco());
    }

    @Test
    public void testToString() {
        // Arrange
        String matricula = "123456";
        String nome = "John Doe";
        String email = "john.doe@example.com";
        String cpf = "123456789";
        String telefone = "1234567890";
        String endereco = "123 Main St";

        AlunoResponseModel aluno = new AlunoResponseModel(matricula, nome, email, cpf, telefone, endereco);

        // Act
        String toStringResult = aluno.toString();

        // Assert
        String expectedToString = "AlunoResponseModel[matricula=123456, nome=John Doe, email=john.doe@example.com, cpf=123456789, telefone=1234567890, endereco=123 Main St]";
        Assertions.assertEquals(expectedToString, toStringResult);
    }
}