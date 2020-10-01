package fr.Aaris.configureTest.controller;

import fr.Aaris.configureTest.model.Produits;
import fr.Aaris.configureTest.repository.ProduitRepository;
import fr.Aaris.configureTest.repository.UserRepository;
import fr.Aaris.configureTest.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DecoupeController {

   /* @Autowired
    ProduitsService produitsService;*/

    @Autowired
    ProduitRepository produitsDAO;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartService cartManager;


    /**
     * Méthode qui va permettre d'ajouter un produit
     */

    @RequestMapping(value = "/decoupe", method = RequestMethod.GET)
    public String ajouterProduit(Model model) {
        Produits produits = new Produits();
        model.addAttribute("produit", produits);
        model.addAttribute("produits", produitsDAO.findAll());
        return "decoupe";
    }

    /**
     * Méthode qui va permettre l'enregistrement du produit choisi par l'utilisateur.
     */

    @RequestMapping(value = "/decoupe", method = RequestMethod.POST)
    public String ajouterProduit(Produits produits) {
            /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            User user = userRepository.findByEmail(username);*/
        Produits newProduit = new Produits(produits.getNom(), produits.getEpaisseur(), produits.getLongueur(), produits.getLargeur());
        //newProduit.setUser(user);
        produitsDAO.save(newProduit);
        double prix1 = (newProduit.getLargeur() * newProduit.getLongueur() * 0.000025f);
        newProduit.setPrix(prix1);
        newProduit.setType("Découpe");
        produitsDAO.save(newProduit);
        //model.addAttribute("user", user);

        return "decoupe";
    }


}