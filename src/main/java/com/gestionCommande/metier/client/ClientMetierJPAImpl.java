package com.gestionCommande.metier.client;

import com.gestionCommande.entities.Client;
import com.gestionCommande.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientMetierJPAImpl implements ClientMetier
{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll()
    {
        return clientRepository.findAll();
    }

    @Override
    public Page<Client> findAll(Pageable pageable)
    {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client save(Client client)
    {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long idClient)
    {
        clientRepository.delete(idClient);
    }

    @Override
    public Client update(Client client)
    {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findClientByName(String clientName)
    {
        return clientRepository.findClientByNom(clientName);
    }

    @Override
    public Page<Client> findClientByNomClient(String nomClient, Pageable pageable)
    {
        return clientRepository.findClientByNom(nomClient,pageable);
    }

    @Override
    public Page<Client> findClientByNomClientLike(String nomClient, Pageable pageable)
    {
        return clientRepository.findProduitByNomProduitLike(nomClient,pageable);
    }

    @Override
    public Optional<Client> findById(Long id)
    {
        return Optional.of(clientRepository.findOne(id));
    }
}
