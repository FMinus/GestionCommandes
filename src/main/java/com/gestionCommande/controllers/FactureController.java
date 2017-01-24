package com.gestionCommande.controllers;

import com.gestionCommande.entities.Facture;
import com.gestionCommande.metier.commande.CommandeMetier;
import com.gestionCommande.metier.facture.FactureMetier;
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
import java.util.Optional;

@Controller
@RequestMapping("facture")
public class FactureController
{
    @Autowired
    private FactureMetier factureMetier;

    @Autowired
    private CommandeMetier commandeMetier;

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String pageCommandes(Model model, @RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name="motCle",defaultValue = "") String motCle)
    {
        Page<Facture> factures = factureMetier.findFactureByClientNameOrClientPrenom("%"+motCle+"%",new PageRequest(page,10));

        int pageCount = factures.getTotalPages();
        int[] pages = new int[pageCount];

        for(int i=0 ; i<pageCount ; i++)
            pages[i]=i;

        model.addAttribute("factures",factures);
        model.addAttribute("commandes",commandeMetier.findAll());
        model.addAttribute("facture",new Facture());
        model.addAttribute("motCle",motCle);
        model.addAttribute("pages",pages);
        model.addAttribute("pageCourante",page);

        return "/facture/page";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addFacture(@Valid Facture facture, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "facture/add";


        factureMetier.save(facture);
        return "redirect:/facture/page";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String initAddFacture(Model model)
    {
        model.addAttribute("facture",new Facture());
        model.addAttribute("commandes",commandeMetier.findAll());
        return "facture/add";
    }

    @RequestMapping(value = "/delete")
    public String deleteProduit(@RequestParam("id") Long id)
    {
        factureMetier.delete(id);
        return "redirect:/facture/page";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editProduit(@Valid Facture facture, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "facture/page";

        factureMetier.save(facture);

        return "redirect:/facture/page";
    }

    @RequestMapping("/detail/{id}")
    public String commandeDetails(@PathVariable("id") Long id, Model model)
    {
        Optional<Facture> factureOptional = factureMetier.findById(id);

        if (!factureOptional.isPresent()) {
            return "redirect:/facture/page";
        }
        model.addAttribute("facture",factureOptional.get());
        model.addAttribute("totalFacture",factureMetier.calculeTotal(factureOptional.get()));
        return "facture/detail";
    }
}
