package com.gestionCommande.metier.facture;

import com.gestionCommande.entities.Facture;
import com.gestionCommande.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureMetierJPAImpl implements FactureMetier
{
    @Autowired
    private FactureRepository factureRepository;

    @Override
    public List<Facture> findAll()
    {
        return factureRepository.findAll();
    }

    @Override
    public Page<Facture> findAll(Pageable pageable)
    {
        return factureRepository.findAll(pageable);
    }

    @Override
    public Facture save(Facture facture)
    {
        return factureRepository.save(facture);
    }

    @Override
    public void delete(Long idFacture)
    {
        factureRepository.delete(idFacture);
    }

    @Override
    public Facture update(Facture facture)
    {
        return factureRepository.save(facture);
    }

    @Override
    public List<Facture> findFactureByClientNameAndClientPrenom(String clientNom, String clientPrenom)
    {
        return factureRepository.findFactureByCommandeClientNomAndCommandeClientPrenom(clientNom,clientPrenom);
    }

    @Override
    public Page<Facture> findFactureByClientNameAndClientPrenom(String clientNom, String clientPrenom, Pageable pageable)
    {
        return factureRepository.findFactureByCommandeClientNomAndCommandeClientPrenom(clientNom,clientPrenom,pageable);
    }

    @Override
    public Optional<Facture> findById(Long id)
    {
        return Optional.of(factureRepository.findOne(id));
    }
}
