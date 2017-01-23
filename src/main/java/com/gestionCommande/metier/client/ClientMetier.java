package com.gestionCommande.metier.client;

import com.gestionCommande.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClientMetier
{
    List<Client> findAll();
    Page<Client> findAll(Pageable pageable);
    Client save(Client Client);
    void delete(Long idClient);
    Client update(Client Client);
    List<Client> findClientByName(String ClientName);
    Page<Client> findClientByNomClient(String nomClient, Pageable pageable);
    Page<Client> findClientByNomClientLike(String nomClient, Pageable pageable);
    Optional<Client> findById(Long id);
}
