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

    //깊은 복사
    public Burger(Burger burger) {
        super(burger.getName(), burger.getPrice(), burger.getKcal());
        this.isBurgerSet = burger.isBurgerSet();
        this.burgerSetPrice = getBurgerSetPrice();
    }
    // 인자로 자기 자신을 받아와서 해당 인자에 새로 값을 추가함

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
