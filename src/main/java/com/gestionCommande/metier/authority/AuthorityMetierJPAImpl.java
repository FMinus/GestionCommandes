package com.gestionCommande.metier.authority;

import com.gestionCommande.entities.Authority;
import com.gestionCommande.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityMetierJPAImpl implements AuthorityMetier
{
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAll()
    {
        return authorityRepository.findAll();
    }

    @Override
    public Page<Authority> findAll(Pageable pageable)
    {
        return authorityRepository.findAll(pageable);
    }

    @Override
    public Authority save(Authority authority)
    {
        return authorityRepository.save(authority);
    }

    @Override
    public void delete(Long idAuthority)
    {
        authorityRepository.delete(idAuthority);
    }

    @Override
    public Authority update(Authority authority)
    {
        return authorityRepository.save(authority);
    }


    @Override
    public Optional<Authority> findById(Long id)
    {
        return Optional.ofNullable(authorityRepository.findOne(id));
    }

    @Override
    public Optional<Authority> findByName(String name)
    {
        return authorityRepository.findByName(name);
    }
}
