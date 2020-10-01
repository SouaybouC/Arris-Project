package fr.Aaris.configureTest.model;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private final List<Item> items;
    private double total;

    public Panier() {
        items = new ArrayList<>();
        total = 0;
    }

    public Item getItem(Produits produits){
        for (Item item : items){
            if(item.getProduits().getId() == produits.getId()){
                return item;
            }
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getItemCount(){
        return items.size();
    }

    public void addItem(Item item){
        addItem(item.getProduits(), item.getQuantity());
    }

    public void addItem(Produits produits, int quantity){
        Item item = getItem(produits);

        if (item != null){
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new Item(produits);
            item.setQuantity(quantity);
            items.add(item);
        }
    }

    public void updateItem(Produits produits, int quantity){ // throws ProductNotFoundException
        Item item = getItem(produits);

        if (item != null){
            item.setQuantity(quantity);
        } else {
            // throw new ProductNotFoundException();
        }
    }

    public void removeItem(Produits produits){ // throws ProductNotFoundException
        Item item = getItem(produits);

        if (item != null){
            items.remove(item);
        } else {
            // throw new ProductNotFoundException();
        }
    }

    public void clear(){
        items.clear();
        total = 0;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public double getTotal(){
        total = 0;
        for (Item item : items) {
            total += item.getSubTotal();
        }
        return total;
    }
}
