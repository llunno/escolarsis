package com.infnet.edu.lucas.escolarsis.Domain.Usuários;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.infnet.edu.lucas.escolarsis.Domain.Disciplina.Disciplina;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "professores")
public class Professor extends Pessoa implements UserDetails {
    
    private String formacao;
    private List<String> cargos;
    private String senha;
    @ManyToMany(mappedBy = "professores")
    private Collection<Disciplina> disciplinas;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.cargos.stream().map(cargo -> new SimpleGrantedAuthority(cargo)).toList();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.getNome();
    }
}
