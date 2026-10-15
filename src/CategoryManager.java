import java.util.Scanner;
public class CategoryManager {
    public static void browse(Scanner input, String[] items, double[] prices, int[] cart){
        boolean addAnother = true;

        while (addAnother) {

            System.out.println("\n DRINK MENU ");

            for (int i = 0; i < items.length; i++) {
                System.out.printf(
                        "%d. %s - $%.2f%n",
                        i + 1,
                        items[i],
                        prices[i]
                );
            }

            System.out.print(
                    "Select drink (1-" + items.length + "): "
            );
            int item = input.nextInt();

            if (item < 1 || item > items.length) {
                System.out.println("Invalid drink number!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (quantity <= 0) {
                System.out.println(
                        "Quantity must be greater than zero."
                );
                continue;
            }

            // Check that the shared cart is valid.
            if (cart == null
                    || cart.length < items.length
                    || prices.length < items.length) {

                System.out.println(
                        "Error: Menu, prices, and cart do not match."
                );
                return;
            }

            // Add the selected quantity to the shared cart.
            int cartIndex = item - 1;
            cart[cartIndex] += quantity;

            System.out.println(
                    "Added to cart: "
                            + quantity + " x " + items[cartIndex]
            );

            System.out.print(
                    "Add another item? (1 = Yes, 0 = No): "
            );
            int choice = input.nextInt();

            if (choice == 1) {
                addAnother = true;
            } else if (choice == 0) {
                addAnother = false;
            } else {
                System.out.println(
                        "Invalid choice. Returning to main menu."
                );
                addAnother = false;
            }
        }
    }
}
