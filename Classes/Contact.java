package Classes;

public class Contact {

    public String getFirstName() {
        return firstName;
    }

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    private String lastName;

    public String getImg() {
        return img;
    }

    private String img;

    public int getContactNumbers() {
        return contactNumbers;
    }

    private int contactNumbers;


        public Contact(String nameF, String nameL, int number){
            this.firstName = nameF;
            this.lastName = nameL;
            this.contactNumbers = number;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("First Name: ").append(firstName).append("\n");
            sb.append("Last Name: ").append(lastName).append("\n");
            sb.append("Flu Address: ").append(contactNumbers).append("\n");
            sb.append("Image: ").append(img).append("\n");
            sb.append("--------------------\n");
            return sb.toString();
        }









}
