package com.gestionCommande.repository;

import com.gestionCommande.entities.Client;
import com.gestionCommande.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>
{
    List<Client> findClientByNom(String nomProduit);
    Page<Client> findClientByNom(String nomProduit, Pageable pageable);


    @Query("select c from Client c where c.nom like :motCle or c.prenom like :motCle ")
    Page<Client> findProduitByNomProduitLike(@Param("motCle") String motCleClient, Pageable pageable);
}
