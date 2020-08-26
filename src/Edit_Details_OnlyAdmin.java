
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
                    int passingChoice = 0;
                    String NewChangesVar = "";
                    String passingUserName = "";
                    String passingPassword = "";
                    for (Object o : a) {

                        JSONObject User = (JSONObject) o;
                        
                        // fixed attributes: programme,
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        // String Role = (String) User.get("Role");

                        if (inp_username.equals(Username) && inp_password.equals(Pwd)) {
                            System.out.println("Hooray, User Exist!");

                            counter1 = true;
                            String UsernameOld = (String) User.get("Username");
                            String PwdOld = (String) User.get("Password");
                            String NameOld = (String) User.get("Name");
                            System.out.println("Enter attributes to be edit:");
                            System.out.println("1. Name");
                            System.out.println("2. Username");
                            System.out.println("3. Password");

                            int Choice = inp.nextInt();
                            switch (Choice) {
                                case 1:
                                    System.out.println("You are about to update the name.");
                                    System.out.println("Old value: " + NameOld);
                                    System.out.println("Please enter New Name: ");
                                    NewChangesVar = inp.next();
                                    passingUserName = Username;
                                    passingPassword = Pwd;
                                    passingChoice = Choice;

                                    break;
                                case 2:
                                    System.out.println("You are about to update the Username.");
                                    System.out.println("Old value: " + UsernameOld);
                                    System.out.println("Please enter New Username: ");
                                    NewChangesVar = inp.next();
                                    passingUserName = Username;
                                    passingPassword = Pwd;
                                    passingChoice = Choice;
                                    break;
                                case 3:
                                    System.out.println("You are about to update the Password.");
                                    System.out.println("Old value: " + PwdOld);
                                    System.out.println("Please enter New Password: ");
                                    NewChangesVar = inp.next();
                                    passingUserName = Username;
                                    passingPassword = Pwd;
                                    passingChoice = Choice;
                                    break;
                            }
                            break;

                        }
                    }

                    System.out.println("Passing Choice: " + passingChoice);
                    System.out.println("Passing Username: " + passingUserName);
                    System.out.println("Passing Password: " + passingPassword);
                    System.out.println("New Values: " + NewChangesVar);

                    Edit_Details_OnlyAdmin_Loop.Edit_Details_OnlyAdmin_Loop(passingChoice, NewChangesVar,
                            passingUserName, passingPassword);
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
