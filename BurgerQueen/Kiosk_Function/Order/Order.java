package BurgerQueen.Kiosk_Function.Order;

import BurgerQueen.Kiosk_Function.Cart.Cart;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder() {
        System.out.println("[ð£] ì£¼ë¬¸ì´ ìë£ëììµëë¤. ");
        System.out.println("[ð£] ì£¼ë¬¸ ë´ì­ì ë¤ìê³¼ ê°ìµëë¤. ");
        System.out.println("-".repeat(50));

        cart.printCart();

        System.out.println("-".repeat(50));
        System.out.printf("ê¸ì¡ í©ê³      : %dì\n", cart.calTotal());
    }
}
