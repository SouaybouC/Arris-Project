package fr.Aaris.configureTest.controller;

import fr.Aaris.configureTest.model.Produits;
import fr.Aaris.configureTest.repository.ProduitRepository;
import fr.Aaris.configureTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MeubleController {

    @Autowired
    ProduitRepository produitsDAO;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/meuble", method = RequestMethod.GET)
    public String ajouterProduit(Model model){
        Produits produits = new Produits();
        model.addAttribute("produit", produits);
        return "meuble";
    }

    /**
     * Méthode qui va permettre l'enregistrement des données du produit choisi par l'utilisateur.
     */

    @RequestMapping(value = "/meuble", method = RequestMethod.POST)
    public String ajouterProduit(Produits produits, Model model) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        //User user = userRepository.findByEmail(username);
        Produits newProduit = new Produits(produits.getNom(), produits.getEpaisseur(), produits.getLongueur(), produits.getLargeur(), produits.getProfondeur());
        //newProduit.setUser(user);
        produitsDAO.save(newProduit);
        double prix1 = (newProduit.getLargeur()* newProduit.getLongueur()* newProduit.getProfondeur()*0.000025f);
        newProduit.setPrix(prix1);
        newProduit.setType("Caisson");
        produitsDAO.save(newProduit);
        return "redirect:/meuble";
    }

}