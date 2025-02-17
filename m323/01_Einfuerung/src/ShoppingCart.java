import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static List<String> cart = new ArrayList<>();
    private static boolean bookAdded = false;

    public static void addItem(String item) {
        cart.add(item);
        if (item.toLowerCase().contains("buch")) {
            bookAdded = true;
        }
    }

    public static void removeItem(String item) {
        cart.remove(item);
        if (!cart.stream().anyMatch(i -> i.toLowerCase().contains("buch"))) {
            bookAdded = false;
        }
    }

    public static List<String> getItems() {
        return new ArrayList<>(cart);
    }

    public static double getDiscountPercentage() {
        return bookAdded ? 5.0 : 0.0;
    }

    public static void main(String[] args) {
        addItem("Laptop");
        System.out.println("Rabatt: " + getDiscountPercentage() + "%"); // 0%

        addItem("Buch: Java Programmierung");
        System.out.println("Rabatt: " + getDiscountPercentage() + "%"); // 5%

        removeItem("Buch: Java Programmierung");
        System.out.println("Rabatt: " + getDiscountPercentage() + "%"); // 0%
    }
}