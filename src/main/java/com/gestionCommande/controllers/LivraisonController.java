package com.gestionCommande.controllers;

import com.gestionCommande.entities.Client;
import com.gestionCommande.entities.Livraison;
import com.gestionCommande.metier.commande.CommandeMetier;
import com.gestionCommande.metier.livraison.LivraisonMetier;
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
@RequestMapping("livraison")
public class LivraisonController
{
    @Autowired
    private LivraisonMetier livraisonMetier;

    @Autowired
    private CommandeMetier commandeMetier;

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String pageLivraison(Model model, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "motCle",defaultValue = "") String motCle)
    {
        Page<Livraison> livraisons = livraisonMetier.findLivraisonByClientNameOrClientPrenom("%"+motCle+"%",new PageRequest(page,10));
        
        int pageCount = livraisons.getTotalPages();
        int[] pages = new int[pageCount];
        
        for(int i=0 ; i<pageCount ; i++)
            pages[i]=i;
        
        model.addAttribute("livraisons",livraisons);
        model.addAttribute("commandes",commandeMetier.findAll());
        model.addAttribute("livraison",new Livraison());
        model.addAttribute("motCle",motCle);
        model.addAttribute("pages",pages);
        model.addAttribute("pageCourante",page);
        
        return "/livraison/page";
    }
    
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String ajoutLivraison(@Valid Livraison livraison, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "livraison/add";

        livraisonMetier.save(livraison);
        
        return "redirect:/livraison/page";
    }
    
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String getAjoutLivraisonPage(Model model)
    {
        model.addAttribute("livraison",new Livraison());
        model.addAttribute("commandes",commandeMetier.findAll());
        return "livraison/add";
        
    }
    
    @RequestMapping(value = "/delete")
    public String deleteLivraison(@RequestParam("id") Long id)
    {
        livraisonMetier.delete(id);
        return "redirect:/livraison/page";
    }
    
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editLivraison(@Valid Livraison livraison, BindingResult bindingResult)
    {
        
        if(bindingResult.hasErrors())
            return "livraison/page";

        livraisonMetier.save(livraison);
        
        return "redirect:/livraison/page";
    }

    @RequestMapping("/detail/{id}")
    public String livraisonDetails(@PathVariable("id") Long id, Model model)
    {
        Optional<Livraison> livraisonOptional = livraisonMetier.findById(id);

        if (!livraisonOptional.isPresent()) {
            return "redirect:/livraison/page";
        }
        model.addAttribute("livraison",livraisonOptional.get());
        return "livraison/detail";
    }
}
