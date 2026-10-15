import java.util.Scanner;
public class RegistrationManager {
    public static String register(Scanner input, int[] memberIDs, String[] memberNames, int memberCount) {

        System.out.println("\n--- NEW MEMBER REGISTRATION ---");

        if (memberCount >= memberIDs.length || memberCount >= memberNames.length) {
            System.out.println("Member registration is full.");
            return null;
        }

        // Loop until a valid name is provided
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your full name: ");
            name = input.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            }
        }

        System.out.println("[PROCESSING REGISTRATION...]");

        // Generate the next available 4-digit member ID
        int newID = 1001;
        for (int i = 0; i < memberCount; i++) {
            if (memberIDs[i] >= newID) {
                newID = memberIDs[i] + 1;
            }
        }

        // Save member information
        memberIDs[memberCount] = newID;
        memberNames[memberCount] = name;

        System.out.println("--------------------------------------");
        System.out.println("SUCCESS: Account created for " + name + "!");
        System.out.println("Your assigned 4-Digit Member ID is: " + newID);
        System.out.println("Please remember this ID for future visits!");
        System.out.println("[Member Status Verified: 15% Discount Activated]");
        System.out.println("Press Enter to proceed to ordering...");

        input.nextLine();

        return name;
    }
}
