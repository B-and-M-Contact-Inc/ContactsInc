package Classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;


public class ContactList {

    ArrayList<Contact> listOfNames = new ArrayList<>();  //list of contacts

    List<String> imgPaths = new ArrayList<String>();

    String directory = "data";
    String filename = "contacts.txt";

    Path contactDirectory = Paths.get(directory);
    Path contactFile = Paths.get(directory, filename);


    public ContactList(String directory, String filename) throws IOException {
        // create filepath names
        this.filename = filename;
        this.directory = directory;

        //create directory if not exist
        if (Files.exists(contactDirectory)) {
            //System.out.println("True IT'S HERE");
        } else {
            //System.out.println("ITS NOT HERE");
            Files.createDirectory(contactDirectory);
        }
        // create file if not exist
        if (Files.exists(contactFile)) {
            //System.out.println("YAY");
            // if it does exist, pull data from file, stick into List
            readFile();
        } else {
            //System.out.println("NOPE");
            Files.createFile(contactFile);
        }
        // Build the asciiArt artPaths ArrayList
        // can I do this with a loop through the asciiArt Folder?
        imgPaths.add("asciiArt/Filch.txt");
        imgPaths.add("asciiArt/Harry.txt");
        imgPaths.add("asciiArt/Hermoine.txt");
        imgPaths.add("asciiArt/Luna.txt");
        imgPaths.add("asciiArt/Maxine.txt");
        imgPaths.add("asciiArt/Nargul.txt");
        imgPaths.add("asciiArt/Ron.txt");
        imgPaths.add("asciiArt/Tom.txt");
        imgPaths.add("asciiArt/Victor.txt");
    }

    private void readFile() throws IOException {
        // reads from txt,
        // create contact for each txt file line
        // add each contact to List
        // format of each line: fname,lname,image,number
        List<String> listName = Files.readAllLines(contactFile);
        for (String name : listName) {
            // create new contact
            if(name.equals("")){
                continue;
            }
            String[] line = name.split(",");

            Contact nameofcontact = new Contact(line[0], line[1], line[2], (line[3])); // parsed string
            // add contact to list
            listOfNames.add(nameofcontact);
        }
        for (Contact contact : listOfNames) {
            System.out.println(contact.getFirstName());
        }
    }

    private void writeFile() throws IOException {
        // copy listOfNames to Contacts.txt
        // the thing we send to .txt needs to be String
        List<String> textFileContents = new ArrayList<>() {
        };
        for (Contact contact : listOfNames) {
            String singleLineData = contact.getFirstName() + "," + contact.getLastName() + "," + contact.getImgFilePath() + "," + contact.getContactNumbers() + "\n";
            textFileContents.add(singleLineData);
        }
        // write textFileContents to Contacts.txt
        Files.write(contactFile, textFileContents);
    }

    public void newContact(Contact contact) throws IOException {
        listOfNames.add(contact);
        writeFile();
    }


    public String viewContacts() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : listOfNames) {
            sb.append(contact.toString() + "\n");
        }
        return sb.toString();
    }

    public void getInfo() throws IOException {
        System.out.println("Please enter the first name of the person you want to ADD to the list");
        Scanner scanner = new Scanner(System.in);
        String snatchFirstName = scanner.nextLine();
        System.out.println("Great! now please enter the last name only.");
        String snatchLastName = scanner.nextLine();
        System.out.println("Please enter the number of the NEW contact.");
        String snatchNumber = (scanner.nextLine());
        // randomly assign ascii art:
        int asciiAssignment = (int) Math.floor(Math.random()*9);
        // check to see if contact name already exists? do not add contact: do add contact
        boolean duplicateExists = false;
        for (Contact contact : listOfNames) {
            if(contact.getFirstName().equalsIgnoreCase(snatchFirstName) && contact.getLastName().equalsIgnoreCase(snatchLastName)){
                duplicateExists = true;
            }
        }
        if(duplicateExists){
             System.out.println("A contact with the input names already exists");
             getInfo();
        } else {
            newContact(new Contact(snatchFirstName, snatchLastName, imgPaths.get(asciiAssignment), snatchNumber));
        }
    }

    public String searchName() {
        System.out.println("Please enter to first name of who you want to search for!");
        Scanner scanner = new Scanner(System.in);
        String fnameCapture = scanner.nextLine();
        System.out.println("Perfect! Now please enter the last name of the person you want to search for!");
        String lnameCapture = scanner.nextLine();
        for (Contact contact : listOfNames) {
            if (fnameCapture.equalsIgnoreCase(contact.getFirstName()) && lnameCapture.equalsIgnoreCase(contact.getLastName())) {
                return contact.getContactNumbers();
            }

        }
        return "";
    }

    public void deleteContact() throws IOException {
        System.out.println("Please enter to first name of who you want to DELETE from the list!");
        Scanner scanner = new Scanner(System.in);
        String fnameCapture = scanner.nextLine();
        System.out.println("Perfect! Now please enter the last name of the person you want to DELETE from the list!");
        String lnameCapture = scanner.nextLine();
        Contact deleteArrayNum = null;
        for (Contact contact : listOfNames) {
            if (fnameCapture.equalsIgnoreCase(contact.getFirstName()) && lnameCapture.equalsIgnoreCase(contact.getLastName())) {
                deleteArrayNum = contact;
            }
            if (deleteArrayNum != null) {
                listOfNames.remove(deleteArrayNum);
                this.writeFile();
                    return;
            }


        }
    }

    public String displayContactsFancy(){
        StringBuilder sb = new StringBuilder();
        int maxCharactersInName = 0;
        int maxCharactersInNumber = 0;
        for (Contact contact : listOfNames) {
            // name length
            int nameLength = contact.getFirstName().length() + contact.getLastName().length() + 1;
            if(nameLength > maxCharactersInName){
                maxCharactersInName = nameLength;
            }

            // number length
            int numLength = contact.getContactNumbers().length();
            if(nameLength > maxCharactersInNumber){
                maxCharactersInNumber = numLength + 3;
            }
        }
        // works so far!
        System.out.println("maxCharactersInNumber = " + maxCharactersInNumber);
        System.out.println("maxCharactersInName = " + maxCharactersInName);

        // build the output string
        String nameSpaces = "";
        int numberOfNameSpaces = maxCharactersInName - 4;
        for(int i = 0; i < numberOfNameSpaces; i++){
            nameSpaces+=" ";
        }

        String numSpaces = "";
        int numberOfNumSpaces = maxCharactersInNumber - 12;
        for(int i = 0; i < numberOfNumSpaces; i ++){
            numSpaces += " ";
        }

        sb.append("Name").append(nameSpaces).append("|").append("Phone Number").append(numSpaces).append("|").append("\n");
        int numberOfDashes = numberOfNameSpaces + numberOfNumSpaces + 20;
        for(int i = 0; i < numberOfDashes; i++){
            sb.append("-");
        }
        sb.append("\n");
        // pull contact information
        for (Contact contact : listOfNames) {
            sb.append(contact.getFirstName()).append(" ").append(contact.getLastName());
            // add spaces and bar
            int tempSpaces = maxCharactersInName - (contact.getFirstName().length() + contact.getLastName().length() + 1);
            for(int i = 0; i < tempSpaces; i++){
                sb.append(" ");
            }
            sb.append("|");

            // append the flooNumber
            sb.append(contact.formatFloo());
            // add spaces to the number
            tempSpaces = maxCharactersInNumber - contact.formatFloo().length();
            for(int i = 0; i < tempSpaces; i++){
                sb.append(" ");
            }
            sb.append("|\n");
        }
        return sb.toString();
    }
}
