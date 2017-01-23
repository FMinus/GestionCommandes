package com.gestionCommande.metier.produit;

import com.gestionCommande.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProduitMetier
{
    List<Produit> findAll();
    Page<Produit> findAll(Pageable pageable);
    Produit save(Produit produit);
    void delete(Long idProduit);
    Produit update(Produit produit);
    List<Produit> findProduitByName(String produitName);
    Page<Produit> findProduitByNomProduit(String nomProduit, Pageable pageable);
    Page<Produit> findProduitByNomProduitLike(String nomProduit, Pageable pageable);
    Optional<Produit> findById(Long id);
}
