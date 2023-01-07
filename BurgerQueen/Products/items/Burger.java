package BurgerQueen.Products.items;

import BurgerQueen.Products.Product;

public class Burger extends Product {
    private boolean isBurgerSet;
    private int burgerSetPrice;

    public Burger(int id, String name, int price, int kcal, boolean isBurgerSet, int burgerSetPrice) {
        super(id, name, price, kcal);
        this.isBurgerSet = isBurgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }

    public boolean isBurgerSet() {
        return isBurgerSet;
    }

    public int getBurgerSetPrice() {
        return burgerSetPrice;
    }

    public void setBurgerSet(boolean burgerSet) {
        isBurgerSet = burgerSet;
    }

    public void setBurgerSetPrice(int burgerSetPrice) {
        this.burgerSetPrice = burgerSetPrice;
    }
}
