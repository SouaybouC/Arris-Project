package fr.Aaris.configureTest.web;


import fr.Aaris.configureTest.dao.ProduitsDAO;
import fr.Aaris.configureTest.model.Produits;
import fr.Aaris.configureTest.model.User;
import fr.Aaris.configureTest.repository.UserRepository;
import fr.Aaris.configureTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class DecoupeController {
    @Autowired
    ProduitsDAO produitsDAO;

    @Autowired
    UserRepository userRepository;

    /**
     * Méthode qui va permettre d'ajouter un produit
     */

    @RequestMapping(value = "/decoupe", method = RequestMethod.GET)
    public String ajouterProduit(Model model) {
        Produits produits = new Produits();
        model.addAttribute("produit", produits);
        return "decoupe";
    }

    /**
     * Méthode qui va permettre l'enregistrement des données utilisateur qui sera stocké dans la base de données.
     */

    @RequestMapping(value = "/decoupe", method = RequestMethod.POST)
    public String ajouterProduit(Produits produits, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByEmail(username);
        Produits newProduit = new Produits(produits.getNom(), produits.getEpaisseur(), produits.getLongueur(), produits.getLargeur());
        newProduit.setUser(user);
        produitsDAO.save(newProduit);
        float prix = 0.000025f;
        float prix1 = (newProduit.getLargeur() * newProduit.getLongueur() * prix);
        newProduit.setPrix(prix1);
        int qte = +1;
        newProduit.setQte(qte);
        newProduit.setType("Découpe");
        produitsDAO.save(newProduit);

        return "redirect:/decoupe";
    }
}
