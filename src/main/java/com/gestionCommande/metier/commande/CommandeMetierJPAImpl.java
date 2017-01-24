package com.gestionCommande.metier.commande;

import com.gestionCommande.entities.Commande;
import com.gestionCommande.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeMetierJPAImpl implements CommandeMetier
{
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List<Commande> findAll()
    {
        return commandeRepository.findAll();
    }

    @Override
    public Page<Commande> findAll(Pageable pageable)
    {
        return commandeRepository.findAll(pageable);
    }

    @Override
    public Commande save(Commande commande)
    {
        return commandeRepository.save(commande);
    }

    @Override
    public void delete(Long idCommande)
    {
        commandeRepository.delete(idCommande);
    }

    @Override
    public Commande update(Commande commande)
    {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> findCommandeByClientID(Long idClient)
    {
        return commandeRepository.findCommandByClientNumeroClient(idClient);
    }

    @Override
    public Page<Commande> findCommandeByClientID(Long idClient, Pageable pageable)
    {
        return commandeRepository.findCommandByClientNumeroClient(idClient,pageable);
    }

    @Override
    public List<Commande> findCommandeByClientNomAndClientPrenom(String clientNom, String clientPrenom)
    {
        return commandeRepository.findCommandByClientNomAndClientPrenom(clientNom,clientPrenom);
    }

    @Override
    public Page<Commande> findCommandeByClientNomAndClientPrenom(String clientNom, String clientPrenom, Pageable pageable)
    {
        return commandeRepository.findCommandByClientNomAndClientPrenom(clientNom,clientPrenom,pageable);
    }

    @Override
    public Page<Commande> findCommandeByClientNomOrClientPrenom(String motCle, Pageable pageable)
    {
        return commandeRepository.findCommandByClientNomOrClientPrenom(motCle,pageable);
    }

    @Override
    public Optional<Commande> findById(Long id)
    {
        return Optional.ofNullable(commandeRepository.findOne(id));
    }
}
