import java.util.Scanner;

public class CartManager {
    public static void viewCart(String[] menuItems, double[] menuPrices, int[] cartQuantities) {
        System.out.println("\n==========================================");
        System.out.println("              CURRENT CART                ");
        System.out.println("==========================================");

        double subtotal = 0.0;
        boolean isEmpty = true;

        for (int i = 0; i < menuItems.length; i++) {
            if (cartQuantities[i] > 0) {
                isEmpty = false;
                double itemTotal = cartQuantities[i] * menuPrices[i];
                subtotal += itemTotal;
                System.out.printf("%-18s x %-2d  $%.2f\n", menuItems[i], cartQuantities[i], itemTotal);
            }
        }

        if (isEmpty) {
            System.out.println("Your cart is currently empty!");
        }

        System.out.println("------------------------------------------");
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.println("==========================================");
    }
}
