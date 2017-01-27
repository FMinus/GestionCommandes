package com.gestionCommande.metier.authority;

import com.gestionCommande.entities.Authority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuthorityMetier
{
    List<Authority> findAll();
    Page<Authority> findAll(Pageable pageable);
    Authority save(Authority authority);
    void delete(Long idAuthority);
    Authority update(Authority authority);
    Optional<Authority> findById(Long id);
    Optional<Authority> findByName(String username);
}
