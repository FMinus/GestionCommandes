package com.gestionCommande.metier.livraison;

import com.gestionCommande.entities.Livraison;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LivraisonMetier
{
    List<Livraison> findAll();
    Page<Livraison> findAll(Pageable pageable);
    Livraison save(Livraison livraison);
    void delete(Long idLivraison);
    Livraison update(Livraison livraison);
    List<Livraison> findLivraisonByClientNameAndClientPrenom(String clientNom,String clientPrenom);
    Page<Livraison> findLivraisonByClientNameAndClientPrenom(String clientNom,String clientPrenom, Pageable pageable);
    Optional<Livraison> findById(Long id);
}
