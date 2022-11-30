package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Contact {

    public String getFirstName() {
        return firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    private String lastName;

    public String getImgFilePath() {
        return imgFilePath;
    }

    private String imgFilePath;

    public int getContactNumbers() {
        return contactNumbers;
    }

    private int contactNumbers;


    public Contact(String nameF, String nameL, String imgFilePath, int number){
        this.firstName = nameF;
        this.lastName = nameL;
        this.contactNumbers = number;
        this.imgFilePath = imgFilePath;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(firstName).append("\n");
        sb.append("Last Name: ").append(lastName).append("\n");
        sb.append("Flu Address: ").append(contactNumbers).append("\n");
        Path imgFile = Paths.get(imgFilePath);
        String image = "";
        try {
            List<String> imageLines = Files.readAllLines(imgFile);
            for (String line : imageLines) {
                if(!Objects.equals(line, "")) {
                    image += line + "\n";
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sb.append("Image: \n").append(image).append("\n");
        sb.append("--------------------\n");
        return sb.toString();
    }
}
