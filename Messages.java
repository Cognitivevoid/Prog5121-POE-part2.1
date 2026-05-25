package passwordcaputure;

/**
 *
 * @author Cognitive daniel
 */

import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Messages {

    public static void Messages() {
    }

    //Message ID 
    public static long generateMessageID() {

Random random = new Random();

        long min = 1000000000L;
        long max = 9999999999L;
        return min + ((long) (random.nextDouble() * (max - min)));
    }
    //Clearance of recipient
public boolean checkRecipient(String recipient) {
    return recipient.startsWith("+27")&& recipient.length() == 12;
    }

public long checkMessage(String message) {
Random random = new Random();
long min = 1000000000L;
long max = 9000000000L;

   return min + ((long) (random.nextDouble() * (max - min)));

    }

    //Message hash strings 
    public static String createMessageHash(
        long messageID,
        int messageCount,
        String message) {
        String[] words = message.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String hash = String.valueOf(messageID).substring(0, 2)+ ":" + messageCount+ ":" + firstWord + lastWord;

        return hash.toUpperCase();

    }

    //Store message in JSON file
    public static void storeMessage(
            long messageID,
            int messageNumber,
            String recipient,
            String message,
            String messageHash) {

        try {

            FileWriter file = new FileWriter("messages.json", true);

            file.write("{\n");
            file.write("\"MessageID\": \"" + messageID + "\",\n");
            file.write("\"MessageNumber\": \"" + messageNumber + "\",\n");
            file.write("\"Recipient\": \"" + recipient + "\",\n");
            file.write("\"Message\": \"" + message + "\",\n");
            file.write("\"MessageHash\": \"" + messageHash + "\"\n");
            file.write("}\n");

            file.close();

            System.out.println("Message stored in JSON file.");

        } catch (IOException e) {

            System.out.println("Error writing to file.");
        }
    }

    //Stores data in message files in file writer
    public static void messages() {

        Scanner myInput = new Scanner(System.in);

        System.out.print("How many messages would you like to send? ");
        int totalMessages = myInput.nextInt();
        myInput.nextLine();

        for (int i = 0; i < totalMessages; i++) {
        int messageCount = i + 1;

   System.out.println("\n===== MESSAGE " + (i + 1) + " =====");

    // Generate Message ID
    long messageID = generateMessageID();

    // Recipient Number
    String recipient;
        do {

        System.out.print("Enter recipient cell number : ");
        recipient = myInput.nextLine();

        }
        while (!checkRecipientCell(recipient));

            // Message rpompt 
            String message;

            do {

    System.out.print("Enter message (less than 250 characters): ");
    message = myInput.nextLine();
    if (message.length() > 250) {

        System.out.println("Message exceeds 250 characters.");
    }

} while (message.length() > 250);

// Create Message Hash
String messageHash = createMessageHash(messageID,messageCount,message);

            // Display message details
            System.out.println("\n===== MESSAGE DETAILS =====");

            System.out.println("Message ID: " + messageID);
            System.out.println("Message Number: " + messageCount);
            System.out.println("Recipient: " + recipient);
            System.out.println("Message: " + message);
            System.out.println("Message Hash: " + messageHash);

    // Options
    System.out.println("\n1. Send Message");
    System.out.println("2. Disregard Message");
    System.out.println("3. Store Message To Send Later");

    System.out.print("Choose option: ");

            int option = myInput.nextInt();
            myInput.nextLine();

            switch (option) {

    case 1:
        System.out.println("Message successfully sent.");
        break;

    case 2:
        System.out.println("Message disregarded.");
        break;

    case 3:

    storeMessage(
            messageID,messageCount,recipient,message,messageHash);

                    System.out.println("Message stored successfully.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Validate Recipient Number
    public static boolean checkRecipientCell(String number) {

        if (number.length() <= 12 && number.startsWith("+")) {

        return true;
        } else {
            System.out.println("Cell number is incorrect.");
            return false;
        }
    }
}
