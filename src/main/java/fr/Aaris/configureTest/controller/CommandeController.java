package fr.Aaris.configureTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("commande")
public class CommandeController {

    @RequestMapping("/new")
    public String nouvelleCommande(Model model){
        return "commande";
    }

}