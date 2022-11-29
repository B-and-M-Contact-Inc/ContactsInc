package Classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;


public class ContactList {

    ArrayList <Contact> listOfNames = new ArrayList<>();  //list of contacts
        String directory = "data";
        String filename = "contacts.txt";

        Path contactDirectory = Paths.get(directory);
        Path contactFile = Paths.get(directory, filename);


            public ContactList(String directory, String filename) throws IOException {
                // create filepath names
                this.filename = filename;
                this.directory = directory;

                //create directory if not exist
                if(Files.exists(contactDirectory)){
                    System.out.println("True IT'S HERE");
                }
                    else {
                    System.out.println("ITS NOT HERE");
                    Files.createDirectory(contactDirectory);
                }
                // create file if not exist
                if(Files.exists(contactFile)){
                    System.out.println("YAY");
                    // if it does exist, pull data from file, stick into List
                    readFile();
                }
                    else{
                    System.out.println("NOPE");
                    Files.createFile(contactFile);
                }
                    //
        }
        private void readFile() throws IOException {
            // reads from txt,
            // create contact for each txt file line
            // add each contact to List
            // format of each line: fname,lname,image,number
            List<String> listName = Files.readAllLines(contactFile);
            for (String name : listName) {
                // create new contact
                String[] line = name.split(",");

                Contact nameofcontact = new Contact(line[0], line[1], line[2], Integer.parseInt(line[3])); // parsed string
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
                String singleLineData = contact.getFirstName() + "," + contact.getLastName() + "," + contact.getImg() + "," + contact.getContactNumbers() + "\n";
                textFileContents.add(singleLineData);
            }
            // write textFileContents to Contacts.txt
            Files.write(contactFile, textFileContents);
        }

        public void newContact(Contact contact) throws IOException {
                listOfNames.add(contact);
                writeFile();
        }


        public String viewContacts(){
                StringBuilder sb = new StringBuilder();
            for (Contact contact : listOfNames) {
                sb.append(contact.toString() + "\n");
            }
            return sb.toString();
        }
}
