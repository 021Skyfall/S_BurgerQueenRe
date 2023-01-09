package BurgerQueen.Kiosk_Function.Order;

import BurgerQueen.Kiosk_Function.Menu.Menu;
import BurgerQueen.Products.Product;
import BurgerQueen.Products.ProductRepository;

public class OrderApp {
    public void start() {
        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getProducts();
        Menu menu = new Menu(products);
    }
}
