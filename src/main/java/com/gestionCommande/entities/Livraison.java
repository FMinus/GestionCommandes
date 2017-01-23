package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Livraison implements Serializable
{
    @Id
    @GeneratedValue
    private Long numeroLivraison;

    private Date dateLivraison;

    @ManyToOne
    private Commande commande;
}
