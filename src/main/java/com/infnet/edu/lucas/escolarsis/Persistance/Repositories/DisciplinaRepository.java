package com.infnet.edu.lucas.escolarsis.Persistance.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, UUID>{

    Optional<Disciplina> findByNome(String nome);
}
