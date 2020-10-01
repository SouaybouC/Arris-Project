package fr.Aaris.configureTest.model;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double total;

    @OneToMany(mappedBy = "commande")
    private List<Produits> produits;

    @ManyToOne
    User user;

    /*@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<LigneCommande> orderItems = new HashSet<>(0);*/

    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    public Commande() {
        super();
    }

    public Commande(long id, double total, List<Produits> produits) {
        this.id = id;
        this.total = total;
        this.produits = produits;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public List<Produits> getProduits() {
        return produits;
    }

    public void setProduits(List<Produits> produits) {
        this.produits = produits;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}