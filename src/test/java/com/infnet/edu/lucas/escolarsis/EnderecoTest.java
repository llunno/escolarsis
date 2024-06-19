package com.infnet.edu.lucas.escolarsis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Endereco;
import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Pessoa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@SpringBootTest
public class EnderecoTest {

    private Endereco endereco;

    @BeforeEach
    public void setup() {
        endereco = new Endereco();
    }

    @Test
    public void testSetAndGetId() {
        // Arrange
        UUID id = UUID.randomUUID();

        // Act
        endereco.setId(id);
        UUID retrievedId = endereco.getId();

        // Assert
        Assertions.assertEquals(id, retrievedId);
    }

    @Test
    public void testSetAndGetCep() {
        // Arrange
        String cep = "12345-678";

        // Act
        endereco.setCep(cep);
        String retrievedCep = endereco.getCep();

        // Assert
        Assertions.assertEquals(cep, retrievedCep);
    }

    @Test
    public void testSetAndGetLogradouro() {
        // Arrange
        String logradouro = "Rua Teste";

        // Act
        endereco.setLogradouro(logradouro);
        String retrievedLogradouro = endereco.getLogradouro();

        // Assert
        Assertions.assertEquals(logradouro, retrievedLogradouro);
    }

    @Test
    public void testSetAndGetBairro() {
        // Arrange
        String bairro = "Centro";

        // Act
        endereco.setBairro(bairro);
        String retrievedBairro = endereco.getBairro();

        // Assert
        Assertions.assertEquals(bairro, retrievedBairro);
    }

    @Test
    public void testSetAndGetCidade() {
        // Arrange
        String cidade = "Rio de Janeiro";

        // Act
        endereco.setCidade(cidade);
        String retrievedCidade = endereco.getCidade();

        // Assert
        Assertions.assertEquals(cidade, retrievedCidade);
    }

    @Test
    public void testSetAndGetEstado() {
        // Arrange
        String estado = "RJ";

        // Act
        endereco.setEstado(estado);
        String retrievedEstado = endereco.getEstado();

        // Assert
        Assertions.assertEquals(estado, retrievedEstado);
    }

    @Test
    public void testSetAndGetComplemento() {
        // Arrange
        String complemento = "Apto 123";

        // Act
        endereco.setComplemento(complemento);
        String retrievedComplemento = endereco.getComplemento();

        // Assert
        Assertions.assertEquals(complemento, retrievedComplemento);
    }

    @Test
    public void testSetAndGetNumero() {
        // Arrange
        String numero = "123";

        // Act
        endereco.setNumero(numero);
        String retrievedNumero = endereco.getNumero();

        // Assert
        Assertions.assertEquals(numero, retrievedNumero);
    }

    @Test
    public void testSetAndGetPais() {
        // Arrange
        String pais = "Brasil";

        // Act
        endereco.setPais(pais);
        String retrievedPais = endereco.getPais();

        // Assert
        Assertions.assertEquals(pais, retrievedPais);
    }

    @Test
    public void testSetAndGetPessoas() {
        // Arrange
        Collection<Pessoa> pessoas = new ArrayList<>();

        // Act
        endereco.setPessoas(pessoas);
        Collection<Pessoa> retrievedPessoas = endereco.getPessoas();

        // Assert
        Assertions.assertEquals(pessoas, retrievedPessoas);
    }

    @Test
    public void testToString() {
        // Arrange
        endereco.setCep("12345-678");
        endereco.setLogradouro("Rua Teste");
        endereco.setBairro("Centro");
        endereco.setCidade("Rio de Janeiro");
        endereco.setEstado("RJ");
        endereco.setComplemento("Apto 123");
        endereco.setNumero("123");
        endereco.setPais("Brasil");

        // Act
        String toString = endereco.toString();

        // Assert
        Assertions.assertTrue(toString.contains("cep=12345-678"));
        Assertions.assertTrue(toString.contains("logradouro=Rua Teste"));
        Assertions.assertTrue(toString.contains("bairro=Centro"));
        Assertions.assertTrue(toString.contains("cidade=Rio de Janeiro"));
        Assertions.assertTrue(toString.contains("estado=RJ"));
        Assertions.assertTrue(toString.contains("complemento=Apto 123"));
        Assertions.assertTrue(toString.contains("numero=123"));
        Assertions.assertTrue(toString.contains("pais=Brasil"));
    }
}