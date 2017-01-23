package com.gestionCommande.controllers;

import com.gestionCommande.entities.Client;
import com.gestionCommande.metier.client.ClientMetier;
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
@RequestMapping("client")
public class ClientController
{
    private ClientMetier clientMetier;

    @Autowired
    public ClientController(ClientMetier clientMetier) {
        this.clientMetier = clientMetier;
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String pageClients(Model model, @RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name="motCle",defaultValue = "") String motCle)
    {
        Page<Client> clients = clientMetier.findClientByNomClientLike("%"+motCle+"%",new PageRequest(page,10));

        int pageCount = clients.getTotalPages();
        int[] pages = new int[pageCount];

        for(int i=0 ; i<pageCount ; i++)
            pages[i]=i;

        model.addAttribute("clients",clients);
        model.addAttribute("motCle",motCle);
        model.addAttribute("pages",pages);
        model.addAttribute("pageCourante",page);
        return "/client/page";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String ajoutClient(@Valid Client client, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "client/add";

        clientMetier.save(client);

        return "redirect:/client/page";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String getAjoutClientPage(Model model)
    {
        model.addAttribute("client",new Client());
        return "client/add";

    }

    @RequestMapping(value = "/delete")
    public String deleteProduit(@RequestParam("id") Long id)
    {
        clientMetier.delete(id);
        return "redirect:/client/page";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editProduit(@Valid Client client, BindingResult bindingResult)
    {
        System.out.println("Modifier : "+client);
        if(bindingResult.hasErrors())
            return "client/page#"+client.getNumeroClient();

       clientMetier.save(client);

        return "redirect:/client/page";
    }
}
