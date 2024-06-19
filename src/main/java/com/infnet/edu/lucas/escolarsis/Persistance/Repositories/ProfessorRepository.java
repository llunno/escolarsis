package com.infnet.edu.lucas.escolarsis.Persistance.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID>{

    Optional<Professor> findByNome(String username);

    @Query("SELECT p FROM Professor p WHERE p.nome = ?1 AND p.senha = ?2")
    Optional<Professor> findByUsernameAndPassword(String username, String password);
}
