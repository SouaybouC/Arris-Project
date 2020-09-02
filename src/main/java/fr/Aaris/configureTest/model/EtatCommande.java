package fr.Aaris.configureTest.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EtatCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Etat_Commande;

    @NotNull
    private String Libelle;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dte;

    public EtatCommande() {
    }

    public EtatCommande(Long id_Etat_Commande, String libelle, Date dte) {
        this.id_Etat_Commande = id_Etat_Commande;
        Libelle = libelle;
        this.dte = dte;
    }

    public Long getId_Etat_Commande() {
        return id_Etat_Commande;
    }

    public void setId_Etat_Commande(Long id_Etat_Commande) {
        this.id_Etat_Commande = id_Etat_Commande;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public Date getDte() {
        return dte;
    }

    public void setDte(Date dte) {
        this.dte = dte;
    }
}

