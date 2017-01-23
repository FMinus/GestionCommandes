package com.gestionCommande.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    public Authority(String name)
    {
        this.name = name;
    }

}
