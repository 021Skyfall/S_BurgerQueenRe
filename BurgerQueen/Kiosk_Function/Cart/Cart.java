package BurgerQueen.Kiosk_Function.Cart;

import BurgerQueen.Products.Product;
import BurgerQueen.Products.items.Burger;
import BurgerQueen.Products.items.Burger_Set;
import BurgerQueen.Products.items.Drink;
import BurgerQueen.Products.items.Side;

import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);

    public void printCart() {
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(50));

        // 장바구니 상품들을 옵션 정보와 함께 출력
        for (Product product : items) {
            if (product instanceof Burger_Set) {
                Burger_Set burgerSet = (Burger_Set) product;
                System.out.printf(" %s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "있음" : "없음"
                );
            } else if (product instanceof Burger) {
                System.out.printf(" %-8s %6d원 (단품)\n",
                        product.getName(),
                        product.getPrice());
            } else if (product instanceof Side) {
                System.out.printf(" %-8s %6d원 (케첩 %d개)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup());
            } else if (product instanceof Drink) {
                System.out.printf(" %-8s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "있음" : "없음");
            }
        }

        System.out.println("-".repeat(50));
        System.out.println("합계 : ");

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scanner.nextLine();
    }
    private int calTotal() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
