package com.gestionCommande.metier.utilisateur;

import com.gestionCommande.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UtilisateurMetier
{
    List<Utilisateur> findAll();
    Page<Utilisateur> findAll(Pageable pageable);
    Utilisateur save(Utilisateur utilisateur);
    void delete(Long idUtilisateur);
    Utilisateur update(Utilisateur utilisateur);
    Page<Utilisateur> findUtilisateurByUsernameLike(String username, Pageable pageable);
    Optional<Utilisateur> findById(Long id);
    Optional<Utilisateur> findByUsername(String username);
    Optional<Utilisateur> login(String username,String password);
}
