package Classes;

import java.io.IOException;
import java.util.Scanner;


public class ContactsManagerApplication {
    public static void main(String[] args) throws IOException {
        var list = new ContactList("data", "contacts.txt"); // first thing that runs
        list.newContact(new Contact("Ron", "Weasley", "<---*", 123890423));

        // Console Loop
        System.out.println("Contacts Manager Application ~ Start");
        System.out.println("---------------------------");
        System.out.println();

        while(true){
            System.out.println("Main menu: ");
            System.out.println("1. View Contacts\n" +
                    "2. Add a new Contact\n" +
                    "3. Search a contact by name\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n");
            // ask for input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){
                case 1: // view contacts
                    System.out.println(list.viewContacts());
                    break;
                case 2: // add a new contact
                    break;
                case 3: // search a contact by name
                    // search by name String(ignore case)
                    //
                    break;
                case 4: // delete an existing contact
                    break;
                case 5: // Exit
                    return;
                default:
                    // invalid input - continue??
                    break;
            }
        }
    }
}


/**/
