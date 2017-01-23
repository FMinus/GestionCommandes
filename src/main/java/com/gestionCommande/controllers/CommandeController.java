package com.gestionCommande.controllers;

import com.gestionCommande.entities.Client;
import com.gestionCommande.entities.Commande;
import com.gestionCommande.metier.client.ClientMetier;
import com.gestionCommande.metier.commande.CommandeMetier;
import com.gestionCommande.metier.produit.ProduitMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("commande")
public class CommandeController
{
    private CommandeMetier commandeMetier;
    private ClientMetier clientMetier;
    private ProduitMetier produitMetier;

    @Autowired
    public CommandeController(CommandeMetier commandeMetier,ClientMetier clientMetier,ProduitMetier produitMetier) {
        this.commandeMetier = commandeMetier;
        this.clientMetier = clientMetier;
        this.produitMetier = produitMetier;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addCommande(Model model)
    {
        model.addAttribute("commande",new Commande());
        model.addAttribute("clients",clientMetier.findAll());
        model.addAttribute("produits",produitMetier.findAll());
        model.addAttribute("selectedProduits",new ArrayList<Long>());

        return "commande/add";
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String pageCommandes(Model model, @RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name="motCle",defaultValue = "") String motCle)
    {
        Page<Commande> commandes = commandeMetier.findCommandeByClientNomOrClientPrenom("%"+motCle+"%",new PageRequest(page,10));

        int pageCount = commandes.getTotalPages();
        int[] pages = new int[pageCount];

        for(int i=0 ; i<pageCount ; i++)
            pages[i]=i;

        model.addAttribute("commandes",commandes);
        model.addAttribute("clients",clientMetier.findAll());
        model.addAttribute("motCle",motCle);
        model.addAttribute("pages",pages);
        model.addAttribute("pageCourante",page);

        return "/commande/page";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addCommande(Commande commande,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "/commande/add";

        commandeMetier.save(commande);

        return "redirect:/commande/page";
    }

    @RequestMapping(value = "/delete")
    public String deleteCommande(@RequestParam("id") Long id)
    {
        commandeMetier.delete(id);
        return "redirect:/commande/page";
    }

    @RequestMapping("/detail/{id}")
    public String commandeDetails(@PathVariable("id") Long id, Model model)
    {
        Optional<Commande> commandeOptional = commandeMetier.findById(id);

        if (!commandeOptional.isPresent()) {
            return "redirect:/commande/page";
        }
        model.addAttribute("commande",commandeOptional.get());
        return "commande/detail";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editProduit(@Valid Commande commande, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "/commande/page";

        System.out.println(commande);
        commandeMetier.save(commande);

        return "redirect:/commande/page";
    }
}
