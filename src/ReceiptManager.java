public class ReceiptManager {
    public static void printReceipt(String name, boolean isMember, String[] items, double[]prices, int[] cart){
        double rawSubtotal = 0.0;
        boolean hasItems = false;
        System.out.println ("\n==================================================");
                System.out.println("            BREWMASTER CAFÉ RECEIPT            ");
        System.out.println("==================================================")  ;
        System.out.println("Customer Name: " + name);
        System.out.println("Status       : " + (isMember ? "Registered Member (15% OFF)" : "Guest"));
        System.out.println("--------------------------------------------------");
        System.out.println("ITEMS ORDERED:");

        // Loop through cart array to display ordered items
        for (int i = 0; i < cart.length; i++){
            if (cart[i] > 0){
                hasItems = true;
                double itemTotal = cart [i] * prices [i];
                rawSubtotal += itemTotal;

                System.out.printf("%-20s x %d = $%.2f%n", items[i], cart[i], itemTotal);
            }
        }
        if (!hasItems){
            System.out.println("   [No items in cart]   ");
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("Subtotal                  : $%.2f\n", rawSubtotal);

        // 15% Member Discount Calculation
        double discount= 0.0;
        if (isMember) {
            discount = rawSubtotal * 0.15;
            System.out.printf("Member Discount (15%% OFF) : -$%.2f\n" , discount);
        }

        double discountedSubtotal = rawSubtotal - discount;

        // 8% Sales Tax Calculation
        double tax = discountedSubtotal * 0.08;
        double grandTotal = discountedSubtotal + tax;

        if (isMember){
            System.out.printf("Subtotal after Discount   : $%.2f\n", discountedSubtotal);
        }
        System.out.printf("Sales Tax (8%%)            : $%.2f\n", tax);
        System.out.println("==================================================");
            System.out.printf("Grand Total               : $%.2f\n", grandTotal);
        System.out.println("==================================================");
            System.out.println("Thank you, " + name + "! Enjoy your drinks!");
        System.out.println("==================================================");
    }
}
