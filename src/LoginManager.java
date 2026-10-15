import java.util.Scanner;

public class MainKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int[] memberIDs = new int[50];
        String[] memberNames = new String[50];
        memberIDs[0] = 1001; memberNames[0] = "Alex";
        memberIDs[1] = 1002; memberNames[1] = "Sarah";
        int memberCount = 2;
        
        String[] menuItems = { "Espresso", "Iced Latte", "Signature Matcha", "Passion Tea" };
        double[] menuPrices = { 3.00, 4.50, 5.00, 4.00 };
        int[] cartQuantities = new int[menuItems.length];
        
        String currentName = "Guest";
        boolean isMember = false;
        
        System.out.println("1. Login | 2. Register | 3. Guest");
        int authChoice = input.nextInt();
        
        if (authChoice == 1) {
            int idx = LoginManager.checkLogin(input, memberIDs, memberCount); // Member 2
            if (idx != -1) { 
                currentName = memberNames[idx]; 
                isMember = true; 
            }
        } else if (authChoice == 2) {
            currentName = RegistrationManager.register(input, memberIDs, memberNames, memberCount); // Member 3
            isMember = true; 
            memberCount++;
        }
        
        // --- MAIN APPLICATION MENU (Leader Orchestration) ---
        boolean running = true;
        while (running) {
            System.out.println("\n==================================================");
            System.out.println("              BREWMASTER Main Menu                ");
            System.out.println("==================================================");
            System.out.println("Customer: " + currentName + " | Status: " + (isMember ? "Member (15% OFF)" : "Guest"));
            System.out.println("--------------------------------------------------");
            System.out.println("1. Browse Menu & Add to Cart");
            System.out.println("2. View Cart & Subtotal");
            System.out.println("3. Checkout & Print Receipt");
            System.out.println("4. Exit / Cancel Order");
            System.out.println("--------------------------------------------------");
            System.out.print("Select Option (1-4): ");
            
            int choice = input.nextInt();
            
            switch (choice) {
                case 1: 
                    CategoryManager.browse(input, menuItems, menuPrices, cartQuantities); 
                    break; // Member 4
                case 2: 
                    CartManager.viewCart(menuItems, menuPrices, cartQuantities); 
                    break; // Member 5
                case 3: 
                    ReceiptManager.printReceipt(currentName, isMember, menuItems, menuPrices, cartQuantities); 
                    running = false; 
                    break; // Leader
                case 4: 
                    System.out.println("\nSession ended. Goodbye!");
                    running = false; 
                    break;
                default:
                    System.out.println("Invalid choice! Please select between 1 and 4.");
            }
        }
        input.close();
    }
}
