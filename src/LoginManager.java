import java.util.Scanner;
public class LoginManager {
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
