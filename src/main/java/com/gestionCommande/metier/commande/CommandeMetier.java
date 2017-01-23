package com.gestionCommande.metier.commande;

import com.gestionCommande.entities.Commande;
import com.gestionCommande.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommandeMetier
{
    List<Commande> findAll();
    Page<Commande> findAll(Pageable pageable);
    Commande save(Commande commande);
    void delete(Long idCommande);
    Commande update(Commande commande);
    List<Commande> findCommandeByClientID(Long idClient);
    Page<Commande> findCommandeByClientID(Long idClient, Pageable pageable);
    List<Commande> findCommandeByClientNomAndClientPrenom(String clientNom,String clientPrenom);
    Page<Commande> findCommandeByClientNomAndClientPrenom(String clientNom,String clientPrenom,Pageable pageable);
    Page<Commande> findCommandeByClientNomOrClientPrenom(String motCle,Pageable pageable);
    Optional<Commande> findById(Long id);
}
