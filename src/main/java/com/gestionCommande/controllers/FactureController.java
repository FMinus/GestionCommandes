package com.gestionCommande.controllers;

import com.gestionCommande.entities.Facture;
import com.gestionCommande.metier.facture.FactureMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("facture")
public class FactureController
{
    @Autowired
    private FactureMetier factureMetier;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addFacture(@Valid Facture facture, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "facture/add";

        System.out.println(facture);

//        factureMetier.save(facture);
        return "redirect:/facture/page";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String initAddFacture(Model model)
    {
        model.addAttribute("facture",new Facture());
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
}
