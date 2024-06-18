package com.infnet.edu.lucas.escolarsis.Persistance.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, UUID>{

}
