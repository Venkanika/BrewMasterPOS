// FILE: MainKiosk.java (Leader / Core Loop)
import java.util.Scanner;
public class MainKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
// Shared 1D Parallel Arrays (Capacity for 50 members)
        int[] memberIDs = new int[50];
        String[] memberNames = new String[50];
        memberIDs[0] = 1001; memberNames[0] = "Alex";
        memberIDs[1] = 1002; memberNames[1] = "Sarah";
        int memberCount = 2;
        String[] menuItems = {"Espresso", "Iced Latte", "Signature Matcha", "Passion Tea"};
        double[] menuPrices = {3.00, 4.50, 5.00, 4.00};
        int[] cartQuantities = new int[menuItems.length];
        String currentName = "Guest";
        boolean isMember = false;
// --- AUTHENTICATION GATE (Member 2 & Member 3 Modules) ---
        System.out.println("1. Login | 2. Register | 3. Guest");
        int authChoice = input.nextInt();
        if (authChoice == 1) {
            int idx = LoginManager.checkLogin(input, memberIDs, memberCount); // Member 2
            if (idx != -1) { currentName = memberNames[idx]; isMember = true; }
        } else if (authChoice == 2) {
            currentName = RegistrationManager.register(input, memberIDs, memberNames, memberCount); // Member 3
            isMember = true; memberCount++;
        }
// --- MAIN APPLICATION MENU (Leader Orchestration) ---
        boolean running = true;
        while (running) {
            System.out.println("\n1. Browse Menu | 2. View Cart | 3. Checkout | 4. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1: CategoryManager.browse(input, menuItems, menuPrices, cartQuantities); break; // Member 4
                case 2: CartManager.viewCart(menuItems, menuPrices, cartQuantities); break; // Member 5
                case 3: ReceiptManager.printReceipt(currentName, isMember, menuItems, menuPrices, cartQuantities); running = false;
                        break; // Leader
                case 4: running = false; break;
            }
        }
        input.close();
    }
}



