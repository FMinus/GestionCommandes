package com.gestionCommande.repository;

import com.gestionCommande.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long>
{
    List<Produit> findProduitByNomProduit(String nomProduit);
    Page<Produit> findProduitByNomProduit(String nomProduit, Pageable pageable);

    @Query("select p from Produit p where p.nomProduit like :motCle")
    Page<Produit> findProduitByNomProduitLike(@Param("motCle") String nomProduit, Pageable pageable);


}
