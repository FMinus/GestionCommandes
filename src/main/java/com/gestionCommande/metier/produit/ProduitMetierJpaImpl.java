package com.gestionCommande.metier.produit;

import com.gestionCommande.entities.Produit;
import com.gestionCommande.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitMetierJpaImpl implements ProduitMetier
{
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> findAll()
    {
        return produitRepository.findAll();
    }

    @Override
    public Page<Produit> findAll(Pageable pageable)
    {
        return produitRepository.findAll(pageable);
    }

    @Override
    public Produit save(Produit produit)
    {
        return produitRepository.save(produit);
    }

    @Override
    public void delete(Long idProduit)
    {
        produitRepository.delete(idProduit);
    }

    @Override
    public Produit update(Produit produit)
    {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> findProduitByName(String produitName)
    {
        return produitRepository.findProduitByNomProduit(produitName);
    }

    @Override
    public Page<Produit> findProduitByNomProduit(String nomProduit, Pageable pageable)
    {
        return produitRepository.findProduitByNomProduit(nomProduit,pageable);
    }

    @Override
    public Page<Produit> findProduitByNomProduitLike(String nomProduit, Pageable pageable)
    {
        return produitRepository.findProduitByNomProduitLike(nomProduit,pageable);
    }

    @Override
    public Optional<Produit> findById(Long id)
    {
        return Optional.ofNullable(produitRepository.findOne(id));
    }
}
