package BurgerQueen.Kiosk_Function.Cart;

import BurgerQueen.Kiosk_Function.Menu.Menu;
import BurgerQueen.Products.Product;
import BurgerQueen.Products.ProductRepository;
import BurgerQueen.Products.items.Burger;
import BurgerQueen.Products.items.Burger_Set;
import BurgerQueen.Products.items.Drink;
import BurgerQueen.Products.items.Side;
import java.util.Scanner;

public class Cart {
    private ProductRepository productRepository;
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);
    private Menu menu;

    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

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
    public int calTotal() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    public void addToCart(int productId) {
        Product product = productRepository.findId(productId);
        chooseOption(product);

        if (product instanceof Burger) {
            Burger burger = (Burger) product;
            if (burger.isBurgerSet()) product = composeSet(burger);
        }
        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items,0,newItems,0,items.length);
        newItems[newItems.length-1] = product;
        items = newItems;

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", product.getName());
    }
    private void chooseOption(Product product) {
        String input;

        if (product instanceof Burger) {
            System.out.printf("단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)",
                    product.getPrice(),
                    ((Burger) product).getBurgerSetPrice());
            input = scanner.nextLine();
            if (input.equals("2")) ((Burger) product).setBurgerSet(true);
        }
        else if (product instanceof Side) {
            System.out.println("케첩은 몇개가 필요하신가요?");
            input = scanner.nextLine();
            ((Side) product).getKetchup();
        }
        else if (product instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = scanner.nextLine();
            if (input.equals("2")) ((Drink) product).setHasStraw(false);
        }
    }
    private Burger_Set composeSet(Burger burger) {
        System.out.println("사이드를 골라주세요");
        menu.printSide(false);

        String sideId = scanner.nextLine();
        Side side = (Side) productRepository.findId(Integer.parseInt(sideId));
        chooseOption(side);

        System.out.println("음료를 골라주세요.");
        menu.printDrink(false);

        String DrinkId = scanner.nextLine();
        Drink drink = (Drink) productRepository.findId(Integer.parseInt(DrinkId));
        chooseOption(drink);

        String name = burger.getName() + "세트";
        int price = burger.getBurgerSetPrice();
        int kcal = burger.getKcal() + side.getKcal() + drink.getKcal();
        return new Burger_Set(name,price,kcal,burger,side,drink);
    }
}
