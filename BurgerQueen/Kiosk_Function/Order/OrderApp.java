package BurgerQueen.Kiosk_Function.Order;

import BurgerQueen.Kiosk_Function.Menu.Menu;
import BurgerQueen.Products.Product;
import BurgerQueen.Products.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    public void start() {
        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getProducts();
        Menu menu = new Menu(products);
        Scanner scanner = new Scanner(System.in);

        System.out.println("🍔 Hello this is BurgerQueen Kiosk");
        sleepMessage();
        System.out.println("🍔 Have a good time at BurgerQueen");
        sleepMessage();
        System.out.println("🍔 BurgerQueen Order Service");

        while (true) {
            menu.printMenu();
            String select = scanner.nextLine();

            if (select.equals("+")) break;
            else if (select.equals("1")) break;
        }
    }

    private static void sleepMessage() {
        System.out.println("-".repeat(60));
        try {Thread.sleep(1000);} catch (Exception e) {}
    }
}
