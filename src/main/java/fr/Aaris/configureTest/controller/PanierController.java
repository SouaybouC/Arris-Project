package fr.Aaris.configureTest.controller;

import fr.Aaris.configureTest.model.Commande;
import fr.Aaris.configureTest.model.Panier;
import fr.Aaris.configureTest.model.Produits;
import fr.Aaris.configureTest.model.User;
import fr.Aaris.configureTest.repository.CommandeRepository;
import fr.Aaris.configureTest.repository.ProduitRepository;
import fr.Aaris.configureTest.repository.UserRepository;
import fr.Aaris.configureTest.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/panier")
public class PanierController {

    @Autowired
    CartService cartManager;
    @Autowired
    CommandeRepository commandeDao;
    @Autowired
    ProduitRepository produitsDAO;
    @Autowired
    UserRepository userRepository;


    @RequestMapping("")
    public String add(HttpSession session, @RequestParam("id") Produits product,
                      @RequestParam(value = "qty", required = false, defaultValue = "1") int qty){
        Panier cart = cartManager.getPanier(session);
        cart.addItem(product, qty);
        return "panier";
    }

    @RequestMapping("/remove")
    public String remove(HttpSession session, @RequestParam("id") Produits product){
        Panier cart = cartManager.getPanier(session);
        cart.removeItem(product);
        return "panier";
    }

    @RequestMapping("/update")
    public String update(HttpSession session, @RequestParam("id") Produits product, @RequestParam("qty") int qty){
        Panier cart = cartManager.getPanier(session);
        cart.updateItem(product, qty);

        return "panier";
    }

    @RequestMapping("/validation")
    public String validation(HttpSession session, Authentication authentication, @RequestParam("id") Produits product){
        Commande commande = new Commande();
        Panier cart = cartManager.getPanier(session);
        commande.setTotal(cart.getTotal());
        if(authentication != null){
            User user = userRepository.findByEmail(authentication.getName());
            commande.setUser(user);
        }

        //commande.getProduits(cart.getItem(produits));
        commandeDao.save(commande);
        //List<Item> items = cartManager.getPanier(session).getItems();



        return "panier";
    }
}