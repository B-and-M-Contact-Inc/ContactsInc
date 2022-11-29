import java.util.Scanner;

public class ContactsManagerApplication {
    public static void main(String[] args) {
        // Console Loop
        System.out.println("Contacts Manager Application ~ Start");
        System.out.println("---------------------------");
        System.out.println();

        while(true){
            System.out.println("Main menu: ");
            System.out.println("1. View Contacts" +
                    "2. Add a new Contact" +
                    "3. Search a contact by name" +
                    "4. Delete an existing contact." +
                    "5. Exit.");
            // ask for input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){
                case 1: // view contacts
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
