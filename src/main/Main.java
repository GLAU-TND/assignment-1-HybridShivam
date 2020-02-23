package main;

import definition.ContactList;
import definition.Person;

import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contactList = new ContactList();
        String firstName;
        String lastName;
        String[] contactNumber = new String[3];
        String email;
        boolean reply = true;
        System.out.println();
        System.out.println(ANSI_CYAN_BACKGROUND + "|||||||||||||||||||||||||||||||||||||||||||||" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Welcome to Hybrid's Contact List Program" + ANSI_RESET);
        System.out.println(ANSI_CYAN_BACKGROUND + "|||||||||||||||||||||||||||||||||||||||||||||" + ANSI_RESET);
        System.out.println();
        while (reply == true) {
            System.out.println("-------------------------------------------");
            System.out.println(
                    ANSI_RED + "Choose an option :" + ANSI_RESET);
            System.out.println("-------------------------------------------");
            System.out.println(ANSI_CYAN + "Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program" + ANSI_RESET);
            int number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    System.out.println(ANSI_YELLOW+"You have chosen to add a new contact: \n" +
                            "Please enter the name of the Person"+ANSI_RESET);
                    System.out.print("First Name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    lastName = scanner.nextLine();
                    contactList.setName(firstName, lastName);
                    contactList.setFirstNameInList(firstName);
                    System.out.print("Contact Number:");
                    contactNumber[0] = scanner.nextLine();
                    for (int i = 1; i <= 2; i++) {
                        System.out.print(ANSI_YELLOW + "Would you like to add new Number (y/n): " + ANSI_RESET);
                        char response = scanner.next().charAt(0);
                        if (response == 'y') {
                            System.out.print("Contact Number: ");
                            contactNumber[i] = scanner.next();
                        } else {
                            break;
                        }
                    }
                    System.out.print(ANSI_YELLOW + "Would you like to add email (y/n): " + ANSI_RESET);
                    char response = scanner.next().charAt(0);
                    if (response == 'y') {
                        System.out.println("Enter the Email:");
                        email = scanner.next();
                    } else {
                        email = null;
                    }
                    Person person = new Person(firstName, lastName, contactNumber, email);

                    contactList.add(person);
                    break;
                case 2:
                    contactList.viewAllContacts();
                    break;
                case 3:
                    System.out.println("Enter the contact name to search: ");
                    String name = scanner.next();
                    contactList.search(name);
                    break;
                case 4:
                    System.out.println("The contact list: ");
                    for (int i = 0; i < contactList.getArrayOfNames().size(); i++) {
                        System.out.println((i + 1) + ". " + contactList.getArrayOfNames().get(i));
                    }
                    if (contactList.getArrayOfNames().size() != 0) {
                        System.out.println(ANSI_RED + "Press the number against the contact to delete it: " + ANSI_RESET);

                        int index = scanner.nextInt();
                        String tempName = contactList.getArrayOfNames().get(index - 1).toString();
                        contactList.delete(index);
                        System.out.println(tempName + " has been deleted from your contacts");
                    } else {
                        System.out.println(ANSI_YELLOW + "NO CONTACTS AVAILABLE" + ANSI_RESET);
                    }
                    break;
                case 5:
                    System.out.println("Exiting ...");
                    reply = false;
                    break;
                default:
                    System.out.println("Invalid Input enter the right input:");
                    break;
            }

        }
    }
}
