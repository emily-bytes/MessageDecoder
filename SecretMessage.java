import java.io.File;
import java.util.Scanner;
import java.io.*;

/**
 * This program decodes a message: Professor Potter, a punning pedantic, practices puzzling her students.
 * She has left a secret message, of unknown length, encoded in a file for you to unravel. The setup is
 * simple: each line of the file contains one char and one non-negative integer. The key to reading the
 * message is organizing the characters in the proper order. The integer indicates the position of the
 * character within the message.
 *
 * @author Emily Lee
 * @version 1.0
 */
public class SecretMessage
{
    /**
     * The main method displays a welcome/goodbye message, asks the user for the name of a file, checks to
     * see that the file exists and contains some data, opens/reads this file once, uses the MessageDecoder
     * class to unravel and display the message, and offers to do it again on another file.
     * @param args Array of command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Declare variables
        String input;               // To store user input
        String filename;            // To store file
        char repeat;                // To store first character
        String message;             // To store decoded message

        // Create Message Decoder object
        MessageDecoder messageDecoder = new MessageDecoder();

        // Create Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Displays welcome message
        welcome();

        do
        {
            do
            {
                // Prompt user for secret file name
                System.out.print("Enter secret file name: ");
                filename = keyboard.next();
            }
            // Check to see if the file exists.
            while (!isValidFile(filename));

            // Display decoded message
            message = messageDecoder.getPlainTextMessage(filename);
            System.out.println(message);

            // Ask user if they would like to try again
            System.out.print("\nWould you like to try again? (no to exit): ");
            input = keyboard.next();
            repeat = input.charAt(0);
        }

        // Repeat util user input is "no"
        while (repeat == 'Y' || repeat == 'y') ;

        // Displays goodbye message
        goodbye();

        // Close scanner
        keyboard.close();
    }

    /**
     * The isValidFile method checks to see that the user-specified file name refers to a valid file
     * on the disk and not a directory. Displays an error message to the user if that is not the case.
     * @param filename File name string to check
     * @return true if file exists on disk and is not a directory
     */
    private static boolean isValidFile(String filename) {
        File path = new File(filename);
        boolean isValid = path.exists() && !path.isDirectory();
        if (!isValid) {
            System.out.println("The file " + filename + " is not found.");
        }
        return isValid;
    }
    /**
     * The welcome method displays a welcome message
     */
    public static void welcome()
    {
        System.out.println("\nThis program reads an encoded message from a file supplied by the user and\n" +
                "displays the contents of the message before it was encoded.\n");
    }

    /**
     * The goodbye method displays a goodbye message
     */
    public static void goodbye()
    {
        System.out.println("\nThank you for using the message decoder.\n");
    }
}

