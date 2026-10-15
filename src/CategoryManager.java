import java.util.Scanner;
public class CategoryManager {
    public static void browse(Scanner input, String[] items, double[] prices, int[] cart){
        boolean addAnother = true;
        while (addAnother) {
            System.out.println("\n DRINK CATEGORIES ");
            System.out.println("1. Coffee");
            System.out.println("2. Matcha");
            System.out.println("3. Juice");
            System.out.print("Select category (1-3): ");

            int category = input.nextInt();

            if (category < 1 || category > 3) {
                System.out.println("Invalid category!");
                continue;
            }

            System.out.println("\n TEMPERATURE ");
            System.out.println("1. Hot");
            System.out.println("2. Cold");
            System.out.print("Select temperature (1-2): ");

            int temperature = input.nextInt();

            if (temperature < 1 || temperature > 2) {
                System.out.println("Invalid temperature!");
                continue;
            }

            String[] drinks = new String[6];
            double[] drinkPrices = new double[6];

            switch (category) {

                case 1:
                    if (temperature == 1) {
                        drinks[0] = "Espresso";
                        drinks[1] = "Hot Latte";
                        drinks[2] = "Americano";
                        drinks[3] = "Mocha";
                        drinks[4] = "Cappuccino";
                        drinks[5] = "Flat White";

                        drinkPrices[0] = 2.50;
                        drinkPrices[1] = 3.00;
                        drinkPrices[2] = 2.50;
                        drinkPrices[3] = 3.50;
                        drinkPrices[4] = 3.50;
                        drinkPrices[5] = 2.50;

                    } else {
                        drinks[0] = "Iced Espresso";
                        drinks[1] = "Iced Latte";
                        drinks[2] = "Iced Americano";
                        drinks[3] = "Iced Mocha";
                        drinks[4] = "Iced Cappuccino";
                        drinks[5] = "Iced Flat White";

                        drinkPrices[0] = 2.80;
                        drinkPrices[1] = 3.50;
                        drinkPrices[2] = 2.80;
                        drinkPrices[3] = 4.00;
                        drinkPrices[4] = 4.50;
                        drinkPrices[5] = 3.00;
                    }
                    break;

                case 2:
                    if (temperature == 1) {
                        drinks[0] = "Hot Matcha Latte";
                        drinks[1] = "Hot Whisked Matcha";
                        drinks[2] = "Hot Strawberry Matcha";
                        drinks[3] = "Hot Blueberry Matcha";
                        drinks[4] = "Hot Salted Cream Matcha";
                        drinks[5] = "Hot Matcha Egg Cream";
                    } else {
                        drinks[0] = "Iced Matcha Latte";
                        drinks[1] = "Cold Whisked Matcha";
                        drinks[2] = "Iced Strawberry Matcha";
                        drinks[3] = "Iced Blueberry Matcha";
                        drinks[4] = "Iced Salted Cream Matcha";
                        drinks[5] = "Iced Matcha Egg Cream";
                    }

                    drinkPrices[0] = 3.50;
                    drinkPrices[1] = 3.00;
                    drinkPrices[2] = 3.80;
                    drinkPrices[3] = 4.00;
                    drinkPrices[4] = 3.50;
                    drinkPrices[5] = 3.00;
                    break;

                case 3:
                    drinks[0] = "Orange Juice";
                    drinks[1] = "Coconut Drink";
                    drinks[2] = "Watermelon Juice";
                    drinks[3] = "Passion Soda";
                    drinks[4] = "Pineapple Juice";
                    drinks[5] = "Grape Juice";

                    drinkPrices[0] = 2.00;
                    drinkPrices[1] = 1.50;
                    drinkPrices[2] = 3.00;
                    drinkPrices[3] = 3.50;
                    drinkPrices[4] = 2.00;
                    drinkPrices[5] = 3.00;
                    break;
            }

            System.out.println("\n DRINK MENU ");

            for (int i = 0; i < drinks.length; i++) {
                System.out.printf(
                        "%d. %s - $%.2f%n",
                        i + 1,
                        drinks[i],
                        drinkPrices[i]
                );
            }

            System.out.print("Select drink (1-6): ");
            int item = input.nextInt();

            if (item < 1 || item > 6) {
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

            // 3 categories x 2 temperatures x 6 drinks = 36 slots.
            int cartIndex =
                    (category - 1) * 12
                            + (temperature - 1) * 6
                            + (item - 1);

            if (cart == null || cart.length < 36) {
                System.out.println(
                        "Cart array must contain at least 36 positions."
                );
                return;
            }

            cart[cartIndex] += quantity;

            System.out.println(
                    "Added to cart: "
                            + quantity + " x " + drinks[item - 1]
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
