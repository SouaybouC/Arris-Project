package fr.Aaris.configureTest.web;
import fr.Aaris.configureTest.dao.ProduitsDAO;
import fr.Aaris.configureTest.model.Produits;
import fr.Aaris.configureTest.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CommandeController {

    @Autowired
    ProduitsDAO produitsDAO;

    @Autowired
    UserRepository userRepository;

    /**
     * Méthode qui va permettre la création d'un nouveau spot
     */

    /*@RequestMapping(value = "/afficheCommande", method = RequestMethod.GET)
    public String creationCommande(Model model) {
        Commandes commande = new Commandes();
        model.addAttribute("commande", commande);
        return "afficheCommande";
    }*/


    /**
     * Méthode qui va permettre d'afficher les produits de la commande.
     */

    @RequestMapping("/afficheCommande")
    public String affichageProduit(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("produits", produitsDAO.findProduitsByUserEmail(username));

        return "afficheCommande";
    }

    /**
     * Méthode qui va permettre la suppression d'un Produits
     */

    @RequestMapping(value = "/delete/{id_Produit}", method = RequestMethod.GET)
    public String supprimerProduit(@PathVariable("id_Produit") Long id, Model model, RedirectAttributes redirectAttrs){
        model.addAttribute("produits", new Produits());
        produitsDAO.deleteById(id);
        //redirectAttrs.addAttribute("id", id);
        return "afficheCommande";
    }

    /**
     * Méthode qui va permettre de valider la commande
     *//* A finir

    @RequestMapping(value="afficheCommande", method = RequestMethod.GET)
    public String validationCommande(Produits produits, Model model){
        Commandes commandes = new Commandes();

        return "afficheCommande";
    }*/
}

