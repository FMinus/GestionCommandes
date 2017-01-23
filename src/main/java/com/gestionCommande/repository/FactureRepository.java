package com.gestionCommande.repository;

import com.gestionCommande.entities.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long>
{
    List<Facture> findFactureByCommandeClientNumeroClient(Long idClient);
    Page<Facture> findFactureByCommandeClientNumeroClient(Long idClient, Pageable pageable);

    List<Facture> findFactureByCommandeClientNomAndCommandeClientPrenom(String nom,String prenom);
    Page<Facture> findFactureByCommandeClientNomAndCommandeClientPrenom(String nom,String prenom, Pageable pageable);
}
