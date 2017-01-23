package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Commande implements Serializable
{
    @Id
    @GeneratedValue
    private Long numeroCommande;

    //    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCommande;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Produit> produits;

    @OneToMany(cascade = CascadeType.REMOVE)
    private Collection<Facture> factures;

    @OneToMany(cascade = CascadeType.REMOVE)
    private Collection<Livraison> livraisons;
}
