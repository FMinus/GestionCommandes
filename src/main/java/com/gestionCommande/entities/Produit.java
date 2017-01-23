package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Produit implements Serializable
{
    @Id
    @GeneratedValue
    private Long numeroProduit;

    @NotNull
    @Size(min = 3,max = 50)
    private String nomProduit;

    @Min(0)
    private int quantite;

    @Min(0)
    private double prix;

    @ManyToMany
    private Collection<Commande> commandes;

}
