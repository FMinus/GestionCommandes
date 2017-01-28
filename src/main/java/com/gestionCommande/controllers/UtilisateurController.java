package com.gestionCommande.controllers;

import com.gestionCommande.entities.Utilisateur;
import com.gestionCommande.metier.authority.AuthorityMetier;
import com.gestionCommande.metier.utilisateur.UtilisateurMetier;
import com.gestionCommande.repository.AuthorityRepository;
import com.gestionCommande.repository.UtilisateurRepository;
import com.gestionCommande.utils.Passwords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping("utilisateur")
public class UtilisateurController
{
    @Autowired
    private UtilisateurMetier utilisateurMetier;

    @Autowired
    private AuthorityMetier authorityMetier;

    @RequestMapping("/current")
    public String getCurrentUser(Principal user,Model model)
    {
        model.addAttribute("currentUser",user);
        return user.getName();
    }

    @RequestMapping("/home")
    public String home(Principal user,Model model)
    {
        model.addAttribute("currentUser",user);
        return "home";
    }

    @RequestMapping("/profile")
    public String profile(Principal user,Model model)
    {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("currentUser",user);
        model.addAttribute("authorities",authorities);

        return "utilisateur/profile";
    }
    
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String pageUtilisateur(Model model, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "motCle",defaultValue = "") String motCle)
    {
        Page<Utilisateur> utilisateurs = utilisateurMetier.findUtilisateurByUsernameLike("%"+motCle+"%",new PageRequest(page,10));
        
        int pageCount = utilisateurs.getTotalPages();
        int[] pages = new int[pageCount];
        
        for(int i=0 ; i<pageCount ; i++)
            pages[i]=i;
        
        model.addAttribute("utilisateurs",utilisateurs);
        model.addAttribute("motCle",motCle);
        model.addAttribute("pages",pages);
        model.addAttribute("pageCourante",page);
        
        return "/utilisateur/page";
    }
    
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String ajoutUtilisateur(@Valid Utilisateur utilisateur, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "utilisateur/register";

        utilisateurMetier.hashPassword(utilisateur);
        utilisateurMetier.save(utilisateur);
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String getAjoutUtilisateurPage(Model model)
    {
        model.addAttribute("utilisateur",new Utilisateur());
        model.addAttribute("authorities",authorityMetier.findAll());
        return "utilisateur/register";
        
    }
    
    @RequestMapping(value = "/delete")
    public String deleteUtilisateur(@RequestParam("id") Long id)
    {
        utilisateurMetier.delete(id);
        return "redirect:/utilisateur/page";
    }
    
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editUtilisateur(@Valid Utilisateur utilisateur, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "utilisateur/page";

        utilisateurMetier.save(utilisateur);
        
        return "redirect:/utilisateur/page";
    }

    public static void main(String[] args)
    {
        System.out.println(Passwords.hashPassword("123"));
    }
}
