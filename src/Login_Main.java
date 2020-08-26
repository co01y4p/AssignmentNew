
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner;

public class Login_Main {

    JSONParser parser = new JSONParser();
    Scanner inp = new Scanner(System.in);
    boolean counter1 = false;
    String passRole;

    public String main() {

        try {

            while (counter1 == false) {
                System.out.println("Welcome back to System!");
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.println("Enter your choice");

                int choice1 = inp.nextInt();
                if (choice1 == 1) {
                    System.out.println("Please Enter your Username: ");

                    String inp_username = inp.next();

                    System.out.println("Please Enter your Password: ");
                    String inp_password = inp.next();
                    JSONArray a = (JSONArray) parser.parse(new FileReader(Main.databasepath));
                    for (Object o : a) {
                        JSONObject User = (JSONObject) o;
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        String Role = (String) User.get("Role");
                        if (inp_username.equals(Username) && inp_password.equals(Pwd)) {
                            counter1 = true;
                            passRole = Role;
                            //here
                            System.out.println("Login successfully");
                            break;
                        }

                    }
                    if (counter1 == false) {
                        System.out.println("Invalid credentials, please try again");
                    }
                } else if (choice1 == 2) {
                    counter1 = true;
                    //go to exit 
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return passRole;
    }

}
