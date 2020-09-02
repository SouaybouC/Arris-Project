package fr.Aaris.configureTest.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Facture;

    @Temporal(TemporalType.DATE)
    private Date dte_Facture;

    @NotNull
    private int prix_Ttc;

    @NotNull
    private int prix_Ht;

    @NotNull
    private int tva;


    public Facture() {
    }

    public Facture(Long id_Facture, Date dte_Facture, int prix_Ttc, int prix_Ht, int tva) {
        this.id_Facture = id_Facture;
        this.dte_Facture = dte_Facture;
        this.prix_Ttc = prix_Ttc;
        this.prix_Ht = prix_Ht;
        this.tva = tva;
    }

    public Long getId_Facture() {
        return id_Facture;
    }

    public void setId_Facture(Long id_Facture) {
        this.id_Facture = id_Facture;
    }

    public Date getDte_Facture() {
        return dte_Facture;
    }

    public void setDte_Facture(Date dte_Facture) {
        this.dte_Facture = dte_Facture;
    }

    public int getPrix_Ttc() {
        return prix_Ttc;
    }

    public void setPrix_Ttc(int prix_Ttc) {
        this.prix_Ttc = prix_Ttc;
    }

    public int getPrix_Ht() {
        return prix_Ht;
    }

    public void setPrix_Ht(int prix_Ht) {
        this.prix_Ht = prix_Ht;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

}
