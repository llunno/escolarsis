package com.infnet.edu.lucas.escolarsis.Business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.infnet.edu.lucas.escolarsis.Domain.Usuários.Professor;
import com.infnet.edu.lucas.escolarsis.Persistance.Repositories.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService implements UserDetailsService {

    @Autowired
    private ProfessorRepository professorRepository;

    public void create(Professor entity) {
        professorRepository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return professorRepository.findByNome(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
