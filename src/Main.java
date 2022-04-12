

import java.io.*;         // Two for one Bonus. add this and you will be fine.
import java.nio.file.*;  // This adds all packages, all in one bonus.
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //Using Stream  so the flow of data from one location to another.
        // Grabbing the file in the data folder to  make a path
        Path productPath = Paths.get("data/contacts.txt");
        // toFile turns your path into a file.
        File contactFile = productPath.toFile();

        //Introduction
        displayMenu();
        int menuChoice = Integer.parseInt(sc.nextLine());  // Read user input

        //If Statement that connects the user to the correct case
        if (menuChoice <= 0 || menuChoice > 5) {
            System.out.println("Invalid selection. ");
        } else if (menuChoice == 1) {
            System.out.println("------------");
            showcaseList(productPath);
        } else if (menuChoice == 2) {
            System.out.println("------------");
            addUser(productPath);
        } else if (menuChoice == 3) {
            System.out.println("------------");
            System.out.println("You have chosen # 3");
            System.out.println("Search a contact by name");
            System.out.println("Enter first name:");
            String searchName = sc.nextLine();

            List<String> listName = Files.readAllLines(productPath);

            for (String name : listName) {
                if (name.equals(searchName)) {
                    System.out.println("Yes we have that name!");
                }else{
                    System.out.println("No we dont have that name");
                }

            }


        } else if (menuChoice == 4) {
            System.out.println("------------");
            System.out.println("You have chosen # 4");
        } else {
            System.out.println("------------");
            System.out.println("You have chosen # 5");

        }


    }

    // Introduction
    public static void displayMenu() {
        System.out.println("\nWelcome to Contact List. What would you like to do? \n");
        // Displayed the introduction page
        // Reader is going to place their input here.
        System.out.println("1. View Contacts" + "\n"
                + "2. Add a new contact" + "\n"
                + "3. Search a contact by name" + "\n"
                + "4. Delete an existing contact" + "\n"
                + "5. Exit");
    }
    // Showcase the users added
    public static void showcaseList(Path productPath) throws IOException {
        List<String> users = Files.readAllLines(productPath);
        System.out.println("You have chosen # 1");
            for (String user : users) {
                System.out.println(user);
            }
        }

    private static void addUser(Path productPath) {
        Scanner sc = new Scanner(System.in);
        System.out.println("You have chosen # 2");
        System.out.println("Enter contact first name:");
        String firstContactName = sc.nextLine();
        System.out.println("Enter contact last name:");
        String lastContactName = sc.nextLine();
        System.out.println("Enter contact phone number:");
        long phoneNumber = Long.parseLong(sc.nextLine());
        //Capitalize the first and last name
        String cap1 = firstContactName.substring(0, 1).toUpperCase();
        String firstNameCapitalized = cap1 + firstContactName.substring(1);
        String cap2 = lastContactName.substring(0, 1).toUpperCase();
        String lastNameCapitalized = cap2 + lastContactName.substring(1);
        //
        try {
            String sentence = firstNameCapitalized + " " + lastNameCapitalized + " | " + phoneNumber + "\n";
            List<String> newUser = Arrays.asList(sentence);
            Files.write(productPath, newUser, StandardOpenOption.APPEND);
            System.out.println("Successfully added user to the list.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Thank you for adding a user to the main list. ");
    }





}


