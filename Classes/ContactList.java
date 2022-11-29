package Classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Paths;



public class ContactList {

    ArrayList <Contact> listOfNames = new ArrayList<>();  //list of contacts
        String directory = "data";
        String filename = "contacts.txt";

        Path contactDirectory = Paths.get(directory);
        Path contactFile = Paths.get(directory, filename);


            public ContactList(String directory, String filename) throws IOException {
                this.filename = filename;
                this.directory = directory;
                if(Files.exists(contactDirectory)){
                    System.out.println("True IT'S HERE");
                }
                    else {
                    System.out.println("ITS NOT HERE");
                    Files.createDirectory(contactDirectory);
                }

                    if(Files.exists(contactFile)){
                        System.out.println("YAY");

                    }
                        else{
                        System.out.println("NOPE");
                        Files.createFile(contactFile);
                    }

        }





}
