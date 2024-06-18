package com.infnet.edu.lucas.escolarsis.Persistance.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID>{

    Optional<Professor> findByNome(String username);
}
