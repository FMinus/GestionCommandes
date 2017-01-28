package com.gestionCommande.dataTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //initialise le context spring
@SpringBootTest             //initialse le context spring en mode test
public class InitData
{
    @Test
    @Sql("/sqlScripts/users.sql")   //le test reussi si le script s'execute sans erreurs
    public void initUsers() {
    }

    @Test
    @Sql("/sqlScripts/produits.sql")
    public void initProduits() {
    }

    @Test
    @Sql("/sqlScripts/clients.sql")
    public void initClients() {
    }
}
