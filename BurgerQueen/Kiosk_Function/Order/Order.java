package BurgerQueen.Kiosk_Function.Order;

import BurgerQueen.Kiosk_Function.Cart.Cart;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder() {
        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(50));

        cart.printCart();

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", cart.calTotal());
    }
}
