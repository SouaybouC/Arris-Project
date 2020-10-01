package fr.Aaris.configureTest.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produits implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String nom;

    private String epaisseur;

    private String type;

    private double longueur;

    private double largeur;

    private double profondeur;

    private double prix;

    @ManyToOne
    private Commande commande;


    public Produits() {
    }

    public Produits(String nom, String epaisseur, double  longueur, double  largeur, double  profondeur) {
        this.nom=nom;
        this.epaisseur = epaisseur;
        this.longueur = longueur;
        this.largeur = largeur;
        this.profondeur = profondeur;
    }



    public Produits(String nom, String epaisseur, double longueur, double largeur) {
        this.nom=nom;
        this.epaisseur = epaisseur;
        this.longueur = longueur;
        this.largeur = largeur;
    }


    public Produits(Long id, String nom, String epaisseur, String type, double longueur, double largeur, double profondeur, double prix, Commande commande) {
        this.id = id;
        this.nom = nom;
        this.epaisseur = epaisseur;
        this.type = type;
        this.longueur = longueur;
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.prix = prix;
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_Produit) {
        this.id= id_Produit;
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

    public double  getLongueur() {
        return longueur;
    }

    public void setLongueur(double longeur) {
        this.longueur = longeur;
    }

    public double  getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double  getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }

    public double  getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public void setCommande(long id) {
    }
}