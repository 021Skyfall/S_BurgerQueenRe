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
        System.out.println("๐งบ ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("-".repeat(50));

        // ์ฅ๋ฐ๊ตฌ๋ ์ํ๋ค์ ์ต์ ์ ๋ณด์ ํจ๊ป ์ถ๋ ฅ
        for (Product product : items) {
            if (product instanceof Burger_Set) {
                Burger_Set burgerSet = (Burger_Set) product;
                System.out.printf(" %s %6d์ (%s(์ผ์ฒฉ %d๊ฐ), %s(๋นจ๋ %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "์์" : "์์"
                );
            } else if (product instanceof Burger) {
                System.out.printf(" %-8s %6d์ (๋จํ)\n",
                        product.getName(),
                        product.getPrice());
            } else if (product instanceof Side) {
                System.out.printf(" %-8s %6d์ (์ผ์ฒฉ %d๊ฐ)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup());
            } else if (product instanceof Drink) {
                System.out.printf(" %-8s %6d์ (๋นจ๋ %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "์์" : "์์");
            }
        }

        System.out.println("-".repeat(50));
        System.out.println("ํฉ๊ณ : ");

        System.out.println("์ด์ ์ผ๋ก ๋์๊ฐ๋ ค๋ฉด ์ํฐ๋ฅผ ๋๋ฅด์ธ์. ");
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

        //๊น์ ๋ณต์ฌ
        Product newProduct;
        if (product instanceof Burger) newProduct = new Burger((Burger) product);
        else if (product instanceof Side) newProduct = new Side((Side) product);
        else if (product instanceof Drink) newProduct = new Drink((Drink) product);
        else newProduct = product;

        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items,0,newItems,0,items.length);
        newItems[newItems.length-1] = product;
        items = newItems;

        System.out.printf("[๐ฃ] %s๋ฅผ(์) ์ฅ๋ฐ๊ตฌ๋์ ๋ด์์ต๋๋ค.\n", product.getName());
    }
    private void chooseOption(Product product) {
        String input;

        if (product instanceof Burger) {
            System.out.printf("๋จํ์ผ๋ก ์ฃผ๋ฌธํ์๊ฒ ์ด์? (1)_๋จํ(%d์) (2)_์ธํธ(%d์)",
                    product.getPrice(),
                    ((Burger) product).getBurgerSetPrice());
            input = scanner.nextLine();
            if (input.equals("2")) ((Burger) product).setBurgerSet(true);
        }
        else if (product instanceof Side) {
            System.out.println("์ผ์ฒฉ์ ๋ช๊ฐ๊ฐ ํ์ํ์ ๊ฐ์?");
            input = scanner.nextLine();
            ((Side) product).getKetchup();
        }
        else if (product instanceof Drink) {
            System.out.println("๋นจ๋๊ฐ ํ์ํ์ ๊ฐ์? (1)_์ (2)_์๋์ค");
            input = scanner.nextLine();
            if (input.equals("2")) ((Drink) product).setHasStraw(false);
        }
    }
    private Burger_Set composeSet(Burger burger) {
        System.out.println("์ฌ์ด๋๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์");
        menu.printSide(false);

        String sideId = scanner.nextLine();
        Side side = (Side) productRepository.findId(Integer.parseInt(sideId));
        Side newSide = new Side(side); // ๊น์ ๋ณต์ฌ
        chooseOption(newSide); // ๊น์ ๋ณต์ฌ

        System.out.println("์๋ฃ๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์.");
        menu.printDrink(false);

        String DrinkId = scanner.nextLine();
        Drink drink = (Drink) productRepository.findId(Integer.parseInt(DrinkId));
        Drink newDrink = new Drink(drink); // ๊น์ ๋ณต์ฌ
        chooseOption(newDrink); // ๊น์ ๋ณต์ฌ

        String name = burger.getName() + "์ธํธ";
        int price = burger.getBurgerSetPrice();
        int kcal = burger.getKcal() + side.getKcal() + drink.getKcal();
        return new Burger_Set(name,price,kcal,burger,newSide,newDrink); // ๊น์๋ณต์ฌ
    }
}
