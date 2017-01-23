package com.gestionCommande.repository;

import com.gestionCommande.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long>
{
    List<Commande> findCommandByClientNumeroClient(Long idClient);
    Page<Commande> findCommandByClientNumeroClient(Long idClient, Pageable pageable);

    List<Commande> findCommandByClientNomAndClientPrenom(String nom,String prenom);
    Page<Commande> findCommandByClientNomAndClientPrenom(String nom,String prenom, Pageable pageable);

    @Query("select c from Commande c where c.client.nom like :motCle or c.client.prenom like :motCle")
    Page<Commande> findCommandByClientNomOrClientPrenom(@Param("motCle") String motCle, Pageable pageable);
}
