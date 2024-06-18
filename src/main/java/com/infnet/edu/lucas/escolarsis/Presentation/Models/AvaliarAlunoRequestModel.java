package com.infnet.edu.lucas.escolarsis.Presentation.Models;

public record AvaliarAlunoRequestModel(
    String alunoId,
    String disciplina,
    String comentario,
    Double nota
) {

}
