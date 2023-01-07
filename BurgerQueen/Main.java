package BurgerQueen;

import BurgerQueen.Products.Product;
import BurgerQueen.Products.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.ListItem();
    }
}