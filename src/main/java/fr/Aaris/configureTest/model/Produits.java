package fr.Aaris.configureTest.model;

import com.sun.istack.NotNull;
import jdk.internal.instrumentation.InstrumentationMethod;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produits implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Produit;

    private String nom;

    private String epaisseur;

    private String type;

    private int longueur;
    @NotNull
    private int largeur;

    @NotNull
    private int profondeur;

    @NotNull
    private float prix;

    @NotNull
    private int qte;

    @ManyToOne
    User user;

    @ManyToOne
    Commandes commandes;

    public Produits() {
    }

    public Produits(String nom, String epaisseur, int longueur, int largeur, int profondeur) {
        this.nom=nom;
        this.epaisseur = epaisseur;
        this.longueur = longueur;
        this.largeur = largeur;
        this.profondeur = profondeur;
    }

    public Produits(String nom, String epaisseur, int longueur, int largeur, int profondeur, User user, Commandes commandes) {
        this.nom=nom;
        this.epaisseur = epaisseur;
        this.longueur = longueur;
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.user = user;
        this.commandes = commandes;
    }


    public Produits(String nom, String epaisseur, int longueur, int largeur) {
        this.nom=nom;
        this.epaisseur = epaisseur;
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public Produits(Long id_Produit,String nom,float prix) {
        this.id_Produit = id_Produit;
        this.nom=nom;
        this.prix=prix;

    }

    public Produits(Long id_Produit, String nom, String epaisseur, String type, int longueur, int largeur, int profondeur, float prix, int qte) {
        this.id_Produit = id_Produit;
        this.nom = nom;
        this.epaisseur = epaisseur;
        this.type = type;
        this.longueur = longueur;
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.prix = prix;
        this.qte = qte;
    }

    public Long getId_Produit() {
        return id_Produit;
    }

    public void setId_Produit(Long id_Produit) {
        this.id_Produit = id_Produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(String epaisseur) {
        this.epaisseur = epaisseur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longeur) {
        this.longueur = longeur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
