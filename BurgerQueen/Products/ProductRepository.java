package BurgerQueen.Products;

import BurgerQueen.Products.items.Burger;
import BurgerQueen.Products.items.Drink;
import BurgerQueen.Products.items.Side;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    Product[] products = {
            new Burger(1,"새우버거",3500,500,false,4500),
            new Burger(2,"치킨버거",4000,600,false,5000),
            new Side(3, "감자튀김",1000,300,1),
            new Side(4,"어니언링",1000,300,1),
            new Drink(5,"코카콜라",1000,200,false),
            new Drink(6,"제로콜라",1000,0,false)
    };

    public Product[] getProducts() {
        return products;
    }
    public void ListItem() {
        List<Product> list = Arrays.asList(products);
        list.forEach(System.out::println);
    }
}
