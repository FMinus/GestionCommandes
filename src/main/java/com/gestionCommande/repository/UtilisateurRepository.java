package com.gestionCommande.repository;

import com.gestionCommande.entities.Client;
import com.gestionCommande.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>
{
    Page<Utilisateur> findUserByUsername(String username, Pageable pageable);
    List<Utilisateur> findUserByUsername(String username);
    Utilisateur findByUsername(String username);
    Utilisateur findFirstByUsername(String username);
    Optional<Utilisateur> findFirstByUsernameAndPassword(String username,String password);

    @Query("select u from Utilisateur u where u.username like :motCle ")
    Page<Utilisateur> findUtilisateurByUsernameLike(@Param("motCle") String username, Pageable pageable);

}
