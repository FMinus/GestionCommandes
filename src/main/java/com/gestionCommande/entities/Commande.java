package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCommande;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Produit> produits;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commande")
    private Collection<Facture> factures;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commande")
    private Collection<Livraison> livraisons;
}
