/**
 * Write a Java program to split an email address into two parts: the username (the part before the @ symbol) 
 * and the domain (the part after the @ symbol). Ensure that the program checks if the email address contains 
 * exactly one @ symbol, and if not, display an appropriate error message.
 * 
 * For example, given the email "user@example.com", the output should be:
 * 
 * Username: user
 * Domain: example.com
 */

package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitEmailId {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        // Lists to store usernames and domains
        List<String> usernames = new ArrayList<>();
        List<String> domains = new ArrayList<>();
        
        System.out.println("Enter the number of email addresses you want to input:");
        int numEmails = scanner.nextInt();
        scanner.nextLine();  // Consume newline after nextInt()
        
        // Loop to input multiple email addresses
        for (int i = 0; i < numEmails; i++) {
            System.out.println("Enter email " + (i + 1) + ":");
            String email = scanner.nextLine();
            
            // Split the email into username and domain
            String[] parts = email.split("@");
            
            // Ensure the email contains exactly one '@'
            if (parts.length == 2) {
                usernames.add(parts[0]);
                domains.add(parts[1]);
            } else {
                System.out.println("Invalid email format: " + email);
            }
        }
        
        // Output the collected usernames and domains
        System.out.println("\nUsernames:");
        for (String username : usernames) {
            System.out.println(username);
        }
        
        System.out.println("\nDomains:");
        for (String domain : domains) {
            System.out.println(domain);
        }
        scanner.close();
    }

}
