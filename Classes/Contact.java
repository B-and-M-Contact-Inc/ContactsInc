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

public class Contact{

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

    public String getContactNumbers() {
        return contactNumbers;
    }

    private String contactNumbers;


    public Contact(String nameF, String nameL, String imgFilePath, String number){
        this.firstName = nameF;
        this.lastName = nameL;
        this.contactNumbers = number;
        this.imgFilePath = imgFilePath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(firstName).append("\n");
        sb.append("Last Name: ").append(lastName).append("\n");
        sb.append("Flu Address: ").append(formatFloo()).append("\n");
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
        sb.append("Image: ").append(image).append("\n");
        sb.append("--------------------\n");
        return sb.toString();
    }

    public String formatFloo(){
        String newFloo = (this.contactNumbers);
        String formattedFloo = "";
        switch(newFloo.length()){
            case 7:
                for(int i = 0; i < newFloo.length(); i++){
                    if(i == 3){
                        formattedFloo += " - ";
                    }
                    formattedFloo += newFloo.charAt(i);
                }
                break;
            case 10:
                for(int i = 0; i < newFloo.length(); i++){
                    if(i == 0){
                        formattedFloo += "(";
                    }
                    if(i == 3){
                        formattedFloo += ")";
                    }
                    if(i == 6){
                        formattedFloo += "-";
                   }
                    formattedFloo += newFloo.charAt(i);
                }
                break;

            default:
                System.out.println("The End");
                break;


        }


        return formattedFloo;
    }


}
