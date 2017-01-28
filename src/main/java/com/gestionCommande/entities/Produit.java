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
    @Size(min = 3,max = 50,message = "longeur doit etre entre 3 et 50")
    private String nomProduit;

    @Min(value =0,message = "valeur doit étre entier positif")
    private int quantite;

    @Min(value = 0,message = "valeur doit étre positif")
    private double prix;

    @ManyToMany
    private Collection<Commande> commandes;

}
