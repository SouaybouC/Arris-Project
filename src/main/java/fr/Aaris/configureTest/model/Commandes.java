package fr.Aaris.configureTest.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Commandes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Commande;

    @NotNull
    private String Paiement;

    @Temporal(TemporalType.DATE)
    private Date dte_Paiement;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dte_Commande;

    @NotNull
    private int total_Commande;

    @OneToOne
    @JoinColumn(name = "idFacture", nullable = false)
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "idEtatCommande", nullable = false)
    private EtatCommande etatCommande;

    @ManyToOne
    User user;


    public Commandes() {
    }

    public Commandes(Long id_Commande, String paiement, Date dte_Paiement, Date dte_Commande, int total_Commande, Facture facture, EtatCommande etatCommande) {
        this.id_Commande = id_Commande;
        Paiement = paiement;
        this.dte_Paiement = dte_Paiement;
        this.dte_Commande = dte_Commande;
        this.total_Commande = total_Commande;
        this.facture = facture;
        this.etatCommande = etatCommande;
    }

    public Commandes(Date dte_Commande, int total_Commande, User user) {
        this.dte_Commande = dte_Commande;
        this.total_Commande = total_Commande;
        this.user = user;
    }

    public Long getId_Commande() {
        return id_Commande;
    }

    public void setId_Commande(Long id_Commande) {
        this.id_Commande = id_Commande;
    }

    public String getPaiement() {
        return Paiement;
    }

    public void setPaiement(String paiement) {
        Paiement = paiement;
    }

    public Date getDte_Paiement() {
        return dte_Paiement;
    }

    public void setDte_Paiement(Date dte_Paiement) {
        this.dte_Paiement = dte_Paiement;
    }

    public Date getDte_Commande() {
        return dte_Commande;
    }

    public void setDte_Commande(Date dte_Commande) {
        this.dte_Commande = dte_Commande;
    }

    public int getTotal_Commande() {
        return total_Commande;
    }

    public void setTotal_Commande(int total_Commande) {
        this.total_Commande = total_Commande;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    /*public List<Produits> getProduits() {
        return produits;
    }

    public void setProduits(List<Produits> produits) {
        this.produits = produits;
    }*/
}
