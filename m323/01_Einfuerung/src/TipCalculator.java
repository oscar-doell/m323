import java.util.List;

public class TipCalculator {
    public static int calculateTipPercentage(List<String> names) {
        if (names.isEmpty()) {
            return 0;
        }
        return names.size() > 5 ? 20 : 10;
    }

    public static void main(String[] args) {
        List<String> group1 = List.of(); // Keine Gruppe
        System.out.println("Trinkgeld: " + calculateTipPercentage(group1) + "%"); // 0%

        List<String> group2 = List.of("Alice", "Bob", "Charlie"); // 1-5 Personen
        System.out.println("Trinkgeld: " + calculateTipPercentage(group2) + "%"); // 10%

        List<String> group3 = List.of("Alice", "Bob", "Charlie", "Dave", "Eve", "Frank"); // Mehr als 5 Personen
        System.out.println("Trinkgeld: " + calculateTipPercentage(group3) + "%"); // 20%
    }
}
