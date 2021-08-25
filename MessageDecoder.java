import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class converts a scrambled message file into plain text.
 * @author Emily Lee
 * @version 1.0
 */
public class MessageDecoder {
    private Node first;              // head of list

    /**
     * The node class stores a list element and a reference to the next node.
     */
    private class Node {

        int number;
        char letter;
        Node next;

        /**
         * Constructor.
         *
         * @param num The element to store in this node.
         */
        Node(int num, char let) {
            number = num;
            letter = let;
            next = null;            // Saving space
        }
    }

    /**
     * The newNode function creates a new node.
     *
     * @param number integer
     * @return Node New node
     */
    public Node newNode(int number, char letter) {
        return new Node(number, letter);
    }

    /**
     * The insertInOrder method sorts nodes in order
     * @param newNode New node
     */
    public int insertInOrder(Node newNode) {
        // Declare variables
        Node current;           // To hold current node

        // If the first node is null or the value in the first node is greater than the new node,
        // the new node becomes the first node
        if (first == null || first.number > newNode.number) {
            newNode.next = first;
            first = newNode;
            return 0;
        }
        // Else the current node becomes the first node
        else {
            // Locate the node before point of insertion
            current = first;     // Will go to beginning of the list

            while (current.next != null && current.next.number < newNode.number) {
                current = current.next;
            }
                if (current.number == newNode.number) {
                    return -1;
                }
            newNode.next = current.next;
            current.next = newNode;
            return 0;
        }
    }

    /**
     * The print method traverses through the linked list and converts the characters to a string
     * @return message String
     */
    String convert() {

        String message = "";
        Node newNode = first;

        while (newNode != null) {
            message += Character.toString(newNode.letter);
            newNode = newNode.next;
        }
        return message;
    }

    /**
     * The isValidNumber method takes in a string with numbers and checks they are all numbers
     * @param number String index
     * @return True or false
     */
    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) < '0' ||  number.charAt(i) >'9') {
                return false;
            }
        }
        return true;
    }

    /**
     * The getPlainTextMessage method takes in a file, reads every line of the file, stores the numbers and
     * characters in a node, creates, a linked list, and sorts the nodes using the numbers, and returns
     * a string message containing only characters.
     *
     * @param filename from user input
     * @return plainTextMessage Decoded Message or error
     * @FileNotFoundException
     */
    public String getPlainTextMessage(String filename) throws FileNotFoundException {
        // Declare variables
        MessageDecoder linkedList = new MessageDecoder();       // Create linked list to hold characters
        Node newNode;                                           // To hold new node
        String message;                                         // To hold error or decoded message

        // Open file
        File file = new File(filename);

        // Open the file for reading
        Scanner inputFile = new Scanner(file);

        // Read the file
        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();                      // Read each line and place into string
            if (str.equals("")) {
                System.out.println("Error.");
                return " ";
            }
            char letter = str.charAt(0);                            // Read each String and place into character
            // Check for missing number
            if (str.length() < 3) {
                System.out.println("Error. Character number is missing.");
                return " ";
            }
            int index = 0;
            if(isValidNumber(str.substring(2))) {
                index = Integer.parseInt(str.substring(2));         // Store each number in node
            }
            else {
                System.out.println("Error. File contains a malformed number");
                return " ";
            }
            // Check for negative number
            if (index < 0 || str.charAt(1) != ' ') {
                System.out.print("Error. The file contains a negative number or is malformed.\n");
                return " ";
            }
            else
            {
                newNode = linkedList.newNode(index, letter);          // Store each character in same node
                int valid = linkedList.insertInOrder(newNode);        // Sort nodes in order by using index only
                // Check for duplicate number
                if (valid < 0) {
                    System.out.println("Error. The file contains a duplicate number.");
                    return " ";
                }
            }
        }
        message = linkedList.convert();                 // Convert characters to string
        return "Decoded: " + message;                   // Return decoded message
    }
}


