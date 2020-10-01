package fr.Aaris.configureTest.model;
import javax.persistence.ManyToOne;

public class Item {

    private Produits produits;
    private int quantity;
    private double subTotal;

    private Long id;

    public Item(Produits produits) {
        this.produits = produits;
        this.quantity = 1;
        this.subTotal = produits.getPrix();
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Item() {
        super();
    }

    public Item(Produits produits, int quantity) {
        this.produits = produits;
        this.quantity = quantity;
    }

    public Produits getProduits() {
        return produits;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        subTotal = produits.getPrix() * quantity;
        return subTotal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
