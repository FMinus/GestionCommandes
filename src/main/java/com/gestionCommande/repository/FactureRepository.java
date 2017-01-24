package com.gestionCommande.repository;

import com.gestionCommande.entities.Client;
import com.gestionCommande.entities.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long>
{
    List<Facture> findFactureByCommandeClientNumeroClient(Long idClient);
    Page<Facture> findFactureByCommandeClientNumeroClient(Long idClient, Pageable pageable);

    List<Facture> findFactureByCommandeClientNomAndCommandeClientPrenom(String nom,String prenom);
    Page<Facture> findFactureByCommandeClientNomAndCommandeClientPrenom(String nom,String prenom, Pageable pageable);

    @Query("select f from Facture f where f.commande.client.nom like :motCle or f.commande.client.prenom like :motCle ")
    Page<Facture> findFactureByNomClientLikeOrPrenomClientLike(@Param("motCle") String motCleClient, Pageable pageable);
}
