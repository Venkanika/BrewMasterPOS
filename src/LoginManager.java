import java.util.Scanner;
public class LoginManager {
//    Display the welcome menu
    public static int showLoginMenu(Scanner input) {
        System.out.println("\n===== BrewMaster POS =====");
        System.out.println("1. Member Login");
        System.out.println("2. Register / Create New Member Account");
        System.out.println("3. Continue as Guest");
        System.out.println("4. Exit");

        System.out.println("Select option(1-4): ");
        int choice = input.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("Invalid option. Please select 1-4");
            System.out.println("Select option(1-4): ");
            choice = input.nextInt();
        }

        return choice;
    }
    public static int checkLogin(Scanner input, int[] memberIDs, int memberCount) {
        System.out.print("Enter your 4-digit Member ID: ");
        int enteredID = input.nextInt();

//        Search for member IDs
        for (int i = 0; i < memberCount; i++) {
            if (memberIDs[i] == enteredID) {
                System.out.println("Login Successful!");
                System.out.println("Welcome back, Member " + enteredID + "!");
                return i;
            }
        }
//        If the ID is not found
        System.out.println("Invalid Member ID. Login failed");
        return -1;
    }
}
