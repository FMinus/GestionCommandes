package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Facture implements Serializable
{
    @Id
    @GeneratedValue
    private Long numeroFacture;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFacture;

    @ManyToOne
    private Commande commande;

    //montant sera calculé par la partie metier
    @Min(0)
    private double additionalCosts;
}
