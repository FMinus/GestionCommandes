package com.gestionCommande.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @Pattern(regexp="\\d{2}[-(]{2}\\d{3}[)]\\d{3}[-]\\d{4}",
            message="numero de telephone non valide - exemple : 11-(222)333-4444")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client",fetch = FetchType.LAZY)
    private List<Commande> commandes;


    public static void main(String[] args)
    {
        String phone = "33-(332)650-9729";

        //123-456-7890
//        String phonePattern = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}";

        String phonePattern = "\\d{2}[-(]{2}\\d{3}[)]\\d{3}[-]\\d{4}";

        if (phone.matches(phonePattern))
            System.out.println("matches");
    }
}

