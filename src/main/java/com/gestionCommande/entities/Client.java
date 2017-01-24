package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Client implements Serializable
{
    @Id
    @GeneratedValue
    private Long numeroClient;

    @NotNull
    @Size(min = 3,max = 25)
    private String nom;

    @NotNull
    @Size(min = 3,max = 25)
    private String prenom;

    @NotNull
    @Size(min = 3,max = 75)
    private String adresse;

    //TODO validate phone
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client",fetch = FetchType.LAZY)
    private List<Commande> commandes;
}
