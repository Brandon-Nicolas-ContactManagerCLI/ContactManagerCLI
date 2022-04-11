import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to Contact List. "
                + "What would you like to do? \n");
        System.out.println("1. View Contacts" + "\n"
                + "2. Add a new contact" + "\n"
                + "3. Search a contact by name" + "\n"
                + "4. Delete an existing contact" + "\n"
                + "5. Exit");
        Integer menuChoice = Integer.valueOf(sc.nextLine());  // Read user input

        if (menuChoice <= 0 || menuChoice > 5) {
            System.out.println("Invalid selection. ");
        }
        if (menuChoice == 1) {

        }


    }
}
