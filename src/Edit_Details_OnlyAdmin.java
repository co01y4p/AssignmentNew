
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner;

public class Edit_Details_OnlyAdmin {

    JSONParser parser = new JSONParser();
    Scanner inp = new Scanner(System.in);
    boolean counter1 = false;
    String passRole;

    public void main() {

        try {

            while (counter1 == false) {
                System.out.println("Welcome back to System!");
                System.out.println("1. Edit Details");
                System.out.println("2. Exit");
                System.out.println("Enter your choice");

                int choice1 = inp.nextInt();
                if (choice1 == 1) {
                    System.out.println("Please Enter his Username: ");
                    String inp_username = inp.next();

                    System.out.println("Please Enter his Password to verify: ");
                    String inp_password = inp.next();

                    JSONArray a = (JSONArray) parser.parse(new FileReader(Main.databasepath));

                    for (Object o : a) {
                        JSONObject User = (JSONObject) o;
                        // fixed attributes: programme,
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        // String Role = (String) User.get("Role");

                        if (inp_username.equals(Username) && inp_password.equals(Pwd)) {
                            counter1 = true;
                            System.out.println("Enter attributes to be edit:");
                            System.out.println("1. Name");
                            System.out.println("2. Username:");
                            System.out.println("3. Password");
                            int Choice = inp.nextInt();
                            switch (Choice) {
                                case 1:
                                
                                case 2:
                                case 3:
                                    // need replace all repeated value in json
                            }

                        }

                    }
                    //here
                    if (counter1 == false) {
                        System.out.println("Invalid credentials, please try again");
                    }
                } else if (choice1 == 2) {
                    counter1 = true;
                    // go to exit
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
