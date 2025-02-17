import java.util.List;

public class FunctionalShoppingCart {
    public static double getDiscountPercentage(List<String> cart) {
        return cart.stream().anyMatch(item -> item.toLowerCase().contains("buch")) ? 5.0 : 0.0;
    }

    public static void main(String[] args) {
        List<String> cart = List.of("Laptop");
        System.out.println("Rabatt: " + getDiscountPercentage(cart) + "%"); // 0%

        cart = List.of("Laptop", "Buch: Java Programmierung");
        System.out.println("Rabatt: " + getDiscountPercentage(cart) + "%"); // 5%

        cart = List.of("Smartphone");
        System.out.println("Rabatt: " + getDiscountPercentage(cart) + "%"); // 0%
    }
}