public class RegistrationManager {
  import java.util.Scanner;

    public static int register( Scanner input, int[] memberIDs, String[] memberNames, int memberCount) {

        System.out.println("\n--- NEW MEMBER REGISTRATION ---");
        System.out.println("Enter your full name: ");

        String name = input.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return memberCount;
        }
        if (memberCount >= memberIDs.length || memberCount >= memberNames.length) {
            System.out.println("Member registration is full.");
            return memberCount;
        }
        System.out.println("[PROCESSING REGISTRATION...");

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

        memberCount++;


        System.out.println("--------------------------------------");
        System.out.println("SUCCESS: Account created for " + name + "!");
        System.out.println("Your assigned 4-Digit Member ID is: " + newID);
        System.out.println("Please remember this Id for future visits! ");

        System.out.println(
                "[Member Status Verified: " + "15% Discount Activated]");
        System.out.println("Press Enter to proceed to ordering...");

        input.nextLine();

        return memberCount;
        }
    }
}
