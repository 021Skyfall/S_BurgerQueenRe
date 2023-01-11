package BurgerQueen.Products.items;

import BurgerQueen.Products.Product;

public class Burger_Set extends Product {
    Burger burger;
    Side side;
    Drink drink;

    public Burger_Set(String name, int price, int kcal, Burger burger, Side side, Drink drink) {
        super(name, price, kcal);
        this.burger = burger;
        this.side = side;
        this.drink = drink;
    }


    public Burger getBurger() {
        return burger;
    }

    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }
}
