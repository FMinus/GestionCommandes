package com.gestionCommande.metier.utilisateur;

import com.gestionCommande.entities.Utilisateur;
import com.gestionCommande.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurMetierJPAImpl implements UtilisateurMetier
{
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> findAll()
    {
        return utilisateurRepository.findAll();
    }

    @Override
    public Page<Utilisateur> findAll(Pageable pageable)
    {
        return utilisateurRepository.findAll(pageable);
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur)
    {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void delete(Long idUtilisateur)
    {
        utilisateurRepository.delete(idUtilisateur);
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur)
    {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Page<Utilisateur> findUtilisateurByUsernameLike(String username, Pageable pageable)
    {
        return utilisateurRepository.findUtilisateurByUsernameLike(username,pageable);
    }

    @Override
    public Optional<Utilisateur> findById(Long id)
    {
        return Optional.ofNullable(utilisateurRepository.findOne(id));
    }

    @Override
    public Optional<Utilisateur> findByUsername(String username)
    {
        return Optional.ofNullable(utilisateurRepository.findByUsername(username));
    }

    @Override
    public Optional<Utilisateur> login(String username, String password)
    {
        return utilisateurRepository.findFirstByUsernameAndPassword(username,password);
    }
}
