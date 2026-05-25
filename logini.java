/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package passwordcaputure;
import java.util.Scanner;
/**
 *
 * @author Cognitive daniel
 */
class logini {
    // Login Method
    public boolean loginUser(
            Scanner scanner,
            String username,
            String password,
            String firstName,
            String lastName) {

        String inputUsername;
        String inputPassword;

        boolean isValid = false;

        while (!isValid) {

            System.out.println("\n=== LOGIN ===");

            System.out.println("Enter username:");
            inputUsername = scanner.nextLine();

            System.out.println("Enter password:");
            inputPassword = scanner.nextLine();

            // Validate Login
            if (inputUsername.equals(username)
                    && inputPassword.equals(password)) {

                System.out.println("Welcome "
                        + firstName + " "
                        + lastName
                        + ", it is great to see you again.");

                isValid = true;
                return true;

            } else {

                System.out.println("Username or password incorrect.");
            }
        }

        return false;
   
   
    
    }
}
    
