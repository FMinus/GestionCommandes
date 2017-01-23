package com.gestionCommande.controllers;

import com.gestionCommande.entities.Produit;
import com.gestionCommande.metier.produit.ProduitMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("produit")
public class ProduitController
{
    @Autowired
    private ProduitMetier produitMetier;

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String pageProduit(Model model, @RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name = "motCle",defaultValue = "") String motCle)
    {
        Page<Produit> produits = produitMetier.findProduitByNomProduitLike("%"+motCle+"%",new PageRequest(page,10));

        int pageCount = produits.getTotalPages();
        int[] pages = new int[pageCount];

        for(int i=0 ; i<pageCount ; i++)
            pages[i]=i;

        model.addAttribute("produits",produits);
        model.addAttribute("motCle",motCle);
        model.addAttribute("pages",pages);
        model.addAttribute("pageCourante",page);

        return "/produit/page";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String ajoutProduit(@Valid Produit produit, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "produit/add";

        produitMetier.save(produit);

        return "redirect:/produit/page";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String getAjoutProduitPage(Model model)
    {
        model.addAttribute("produit",new Produit());
        return "produit/add";

    }

    @RequestMapping(value = "/delete")
    public String deleteProduit(@RequestParam("id") Long id)
    {
        produitMetier.delete(id);
        return "redirect:/produit/page";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editProduit(@Valid Produit produit, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "produit/page";

        produitMetier.save(produit);

        return "redirect:/produit/page";
    }
}
