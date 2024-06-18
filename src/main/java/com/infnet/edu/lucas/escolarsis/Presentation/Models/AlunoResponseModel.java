package com.infnet.edu.lucas.escolarsis.Presentation.Models;

public record AlunoResponseModel(
    String matricula,
    String nome,
    String email,
    String cpf,
    String telefone,
    String endereco
) {

}
