package passwordcaputure;

import java.util.Scanner;

public class Passwordcaputure {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        // DECLARATIONS VARIABLES
        String username = "";
        String password = "";
        String phoneNumber = "";
        String Firstname ="";
        String Lastname ="";
        String registerUser = "";

        boolean checkUserName = false;
        boolean checkPasswordComplexity = false;
        boolean checkCellPhoneNumber = false;
        boolean isValid = false; // fixed naming

        //user initials 
        System.out.println("Enter Firstname:");
        Firstname = input.next();

        System.out.println("Enter Lastname:");
        Lastname = input.next();

        // Username looping
        while (!checkUserName) {
          //dispaly 
            System.out.println("Enter username:");
            username = input.next();

            checkUserName = checkUserName(username);
        //Username conditions 
            if (!checkUserName) {
                System.out.println("Username invalid.");
                System.out.println("Must contain _ and be 5 characters or less.");
            }
        }

        // Pssword looping
        while (!checkPasswordComplexity) {
            //display
            System.out.println("Enter password:");
            System.out.println("username must contain an underscore,one capital letter,one number"
                    + "one special character and is no more than 8 charecters long.");
            password = input.next();

            checkPasswordComplexity = checkPasswordComplexity(password);
           //password conditions
            if (!checkPasswordComplexity) {
                System.out.println("Password invalid.");
                System.out.println("Must contain:");
                System.out.println("- at least 8 characters");
                System.out.println("- one capital letter");
                System.out.println("- one number");
                System.out.println("- one special character");
            }
        }

        //phone number looping 
        while (!checkCellPhoneNumber) {
//display

            System.out.println("Enter phone number:");
            System.out.println("Must start with +27 and be 8 characters long.");
            phoneNumber = input.next();

            checkCellPhoneNumber = checkCellPhoneNumber(phoneNumber);
//phone number conditions 
            if (!checkCellPhoneNumber) {
                System.out.println("Phone number invalid.");
                System.out.println("Must start with +27 and be 8 characters long.");
            }
        }

        // REGISTRATION SUCCESS
        System.out.println("Registration successful!\n");

        
        input.nextLine(); 

        while (!isValid) {

        System.out.println("<<< LOGIN >>>");

            System.out.println("Enter your username:");
            String inputUsername = input.nextLine();

         System.out.println("Enter your password:");
            String inputPassword = input.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {

        isValid = true;

        System.out.println("Welcome " + Firstname + " " + Lastname + ", it is great to see you again.");
            } else {
                System.out.println("Username or password incorrect, try again.\n");
      }
             Messages.messages();
      }
    }
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public static boolean checkPasswordComplexity(String password) {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {

          char ch = password.charAt(i);

    if (Character.isUpperCase(ch)) 
    { hasCapital = true;
            }
            if (Character.isDigit(ch)) 
            { hasNumber = true;
            }
            if (!Character.isLetterOrDigit(ch)) { // FIXED HERE
                hasSpecial = true;
            }
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    //phone number regex 
    public static boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("+27") && phoneNumber.length() == 12;
  
      // Call the message app after registration
       

    }

}


     
    
    