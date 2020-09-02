package fr.Aaris.configureTest.web;
import fr.Aaris.configureTest.dao.ProduitsDAO;
import fr.Aaris.configureTest.model.Produits;
import fr.Aaris.configureTest.model.User;
import fr.Aaris.configureTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MeubleController {

    @Autowired
    ProduitsDAO produitsDAO;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/meuble", method = RequestMethod.GET)
    public String ajouterProduit(Model model){
        Produits produits = new Produits();
        model.addAttribute("produit", produits);
        return "meuble";
    }

    /**
     * Méthode qui va permettre l'enregistrement des données utilisateur qui sera stocké dans la base de données.
     */

    @RequestMapping(value = "/meuble", method = RequestMethod.POST)
    public String ajouterProduit(Produits produits, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByEmail(username);
        Produits newProduit = new Produits(produits.getNom(), produits.getEpaisseur(), produits.getLongueur(), produits.getLargeur(), produits.getProfondeur());
        newProduit.setUser(user);
        produitsDAO.save(newProduit);
        float prix = 0.000025f;
        float prix1 = (newProduit.getLargeur()* newProduit.getLongueur()* newProduit.getProfondeur()*prix);
        newProduit.setPrix(prix1);
        int qte=+1;
        newProduit.setQte(qte);
        newProduit.setType("Caisson");
        produitsDAO.save(newProduit);
        return "redirect:/meuble";
    }

}
