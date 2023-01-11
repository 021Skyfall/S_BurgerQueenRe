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
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printBurger(true);

        printSide(true);

        printDrink(true);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    public void printDrink(boolean printPrice) {
        System.out.println("🥤 음료");
//        여기에서 음료 출력
        for (Product product : products) {
            if (product instanceof Drink) {
                System.out.printf(
                        "   (%d) %s %5dKcal %5d원\n",
                        product.getId(), product.getName(), product.getKcal(), product.getPrice()
                );
            }
        }
        System.out.println();
    }

    public void printSide(boolean printPrice) {
        System.out.println("🍟 사이드");
//        여기에서 사이드 출력
        for (Product product : products) {
            if (product instanceof Side) {
                System.out.printf(
                        "   (%d) %s %5dKcal %5d원\n",
                        product.getId(), product.getName(), product.getKcal(), product.getPrice()
                );
            }
        }
        System.out.println();
    }

    private void printBurger(boolean printPrice) {
        System.out.println("🍔 햄버거");
//        여기에서 햄버거 출력
        for (Product product : products) {
            if (product instanceof Burger) {
                System.out.printf(
                        "   (%d) %s %5dKcal %5d원\n",
                        product.getId(), product.getName(), product.getKcal(), product.getPrice()
                );
            }
        }
        System.out.println();
    }
}
