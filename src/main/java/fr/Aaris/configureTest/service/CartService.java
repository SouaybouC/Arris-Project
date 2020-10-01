package fr.Aaris.configureTest.service;

import fr.Aaris.configureTest.model.Panier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service

public class CartService {

    private static final String SESSION_KEY_SHOPPING_PANIER = "panier";

    public Panier getPanier(HttpSession session){
        Panier panier = (Panier) session.getAttribute(SESSION_KEY_SHOPPING_PANIER);

        if(panier == null){
            panier = new Panier();
            setCart(session, panier);
        }

        return panier;
    }

    public void setCart(HttpSession session, Panier panier){
        session.setAttribute(SESSION_KEY_SHOPPING_PANIER, panier);
    }

    public void removeCart(HttpSession session){
        session.removeAttribute(SESSION_KEY_SHOPPING_PANIER);
    }
}
