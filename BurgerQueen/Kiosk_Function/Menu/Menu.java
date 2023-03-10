package BurgerQueen.Kiosk_Function.Menu;


import BurgerQueen.Products.Product;
import BurgerQueen.Products.items.Burger;
import BurgerQueen.Products.items.Drink;
import BurgerQueen.Products.items.Side;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[๐ป] ๋ฉ๋ด");
        System.out.println("-".repeat(60));

        printBurger(true);

        printSide(true);

        printDrink(true);

        System.out.println();
        System.out.println("๐งบ (0) ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("๐ฆ (+) ์ฃผ๋ฌธํ๊ธฐ");
        System.out.println("-".repeat(60));
        System.out.print("[๐ฃ] ๋ฉ๋ด๋ฅผ ์ ํํด์ฃผ์ธ์ : ");
    }

    public void printDrink(boolean printPrice) {
        System.out.println("๐ฅค ์๋ฃ");
//        ์ฌ๊ธฐ์์ ์๋ฃ ์ถ๋ ฅ
        for (Product product : products) {
            if (product instanceof Drink) {
                System.out.printf(
                        "   (%d) %s %5dKcal %5d์\n",
                        product.getId(), product.getName(), product.getKcal(), product.getPrice()
                );
            }
        }
        System.out.println();
    }

    public void printSide(boolean printPrice) {
        System.out.println("๐ ์ฌ์ด๋");
//        ์ฌ๊ธฐ์์ ์ฌ์ด๋ ์ถ๋ ฅ
        for (Product product : products) {
            if (product instanceof Side) {
                System.out.printf(
                        "   (%d) %s %5dKcal %5d์\n",
                        product.getId(), product.getName(), product.getKcal(), product.getPrice()
                );
            }
        }
        System.out.println();
    }

    private void printBurger(boolean printPrice) {
        System.out.println("๐ ํ๋ฒ๊ฑฐ");
//        ์ฌ๊ธฐ์์ ํ๋ฒ๊ฑฐ ์ถ๋ ฅ
        for (Product product : products) {
            if (product instanceof Burger) {
                System.out.printf(
                        "   (%d) %s %5dKcal %5d์\n",
                        product.getId(), product.getName(), product.getKcal(), product.getPrice()
                );
            }
        }
        System.out.println();
    }
}
