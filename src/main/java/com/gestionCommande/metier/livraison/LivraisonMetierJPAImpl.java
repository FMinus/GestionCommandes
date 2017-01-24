package com.gestionCommande.metier.livraison;

import com.gestionCommande.entities.Livraison;
import com.gestionCommande.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonMetierJPAImpl implements LivraisonMetier
{
    @Autowired
    private LivraisonRepository livraisonRepository;

    @Override
    public List<Livraison> findAll()
    {
        return livraisonRepository.findAll();
    }

    @Override
    public Page<Livraison> findAll(Pageable pageable)
    {
        return livraisonRepository.findAll(pageable);
    }

    @Override
    public Livraison save(Livraison livraison)
    {
        return livraisonRepository.save(livraison);
    }

    @Override
    public void delete(Long idLivraison)
    {
        livraisonRepository.delete(idLivraison);
    }

    @Override
    public Livraison update(Livraison livraison)
    {
        return livraisonRepository.save(livraison);
    }

    @Override
    public List<Livraison> findLivraisonByClientNameAndClientPrenom(String clientNom, String clientPrenom)
    {
        return livraisonRepository.findLivraisonByCommandeClientNomAndCommandeClientPrenom(clientNom,clientPrenom);
    }

    @Override
    public Page<Livraison> findLivraisonByClientNameAndClientPrenom(String clientNom, String clientPrenom, Pageable pageable)
    {
        return livraisonRepository.findLivraisonByCommandeClientNomAndCommandeClientPrenom(clientNom,clientPrenom,pageable);
    }

    @Override
    public Optional<Livraison> findById(Long id)
    {
        return Optional.ofNullable(livraisonRepository.findOne(id));
    }

    @Override
    public Page<Livraison> findLivraisonByClientNameOrClientPrenom(String clientMotCle, Pageable pageable)
    {
        return livraisonRepository.findLivraisonByNomClientLikeOrPrenomClientLike(clientMotCle,pageable);
    }
}
