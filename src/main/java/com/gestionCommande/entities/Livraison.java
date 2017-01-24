package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateLivraison;

    @ManyToOne
    private Commande commande;
}
