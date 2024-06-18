package com.infnet.edu.lucas.escolarsis.Presentation.Models;

import java.util.UUID;

public record DisciplinaResponseModel(
    UUID codigo,
    String nome,
    String descricao,
    int totalAlunos,
    int totalProfessores
) {

}
