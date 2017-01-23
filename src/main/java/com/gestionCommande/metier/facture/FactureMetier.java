package com.gestionCommande.metier.facture;

import com.gestionCommande.entities.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FactureMetier
{
    List<Facture> findAll();
    Page<Facture> findAll(Pageable pageable);
    Facture save(Facture facture);
    void delete(Long idFacture);
    Facture update(Facture facture);
    List<Facture> findFactureByClientNameAndClientPrenom(String clientNom,String clientPrenom);
    Page<Facture> findFactureByClientNameAndClientPrenom(String clientNom,String clientPrenom, Pageable pageable);
    Optional<Facture> findById(Long id);
}
