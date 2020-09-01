
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Scanner;


public class Login_Home {

    public void main() {
        Scanner input1 = new Scanner(System.in);
        JSONParser parser = new JSONParser();

        int choice1;
        Login_Main newLogin = new Login_Main();
        ArrayList a = newLogin.main();
        String role1 = a.get(0).toString();
        String username1 = a.get(1).toString();
        String name1 = a.get(2).toString();

        boolean counter1 = true;

        switch (role1) {
            case "1": // admin
                while (counter1 == true) {
                    System.out.print("Welcome back, Admin " + name1);
                    System.out.print("Please Enter your desire action:");
                    System.out.print("1. Register New User");
                    System.out.print("2. Edit Existing User");
                    System.out.print("3. Exit");
                    choice1 = input1.nextInt();
                    if (choice1 == 1) {
                        counter1 = false;
                        Register_Main newReg = new Register_Main();
                        newReg.Register_Main();

                    } else if (choice1 == 2) {
                        Edit_Details_OnlyAdmin newEdit = new Edit_Details_OnlyAdmin();
                        newEdit.main();
                        counter1 = false;

                    } else if (choice1 == 3) {
                        counter1 = false;

                    } else {
                        System.out.print("Oops! Something went wrong, Please try again!");
                    }
                }
                break;

            case "2": // Lecturer
                while (counter1 == true) {
                    System.out.print("Welcome back, Lecturer " + name1);
                    System.out.print("Please Enter your desire action:");
                    System.out.print("1. Update Student's mark");
                    System.out.print("2. Exit");
                    choice1 = input1.nextInt();
                    if (choice1 == 1) {
                        Edit_Marks_OnlyLecturer newEdit2 = new Edit_Marks_OnlyLecturer();
                        newEdit2.main();
                        counter1 = false;
                    } else if (choice1 == 2) {
                        counter1 = false;
                    } else {
                        System.out.print("Oops! Something went wrong, Please try again!");
                    }
                }
                break;
            case "3": // student
                while (counter1 == true) {
                    System.out.println("Welcome back, Student " + name1);
                    System.out.println("Please Enter your desire action:");
                    System.out.println("1. View Mark");
                    System.out.println("2. Exit");
                    choice1 = input1.nextInt();
                    if (choice1 == 1) {
                        counter1 = false;
                        try {
                            JSONArray parser1 = (JSONArray) parser.parse(new FileReader(Main.databasepath));
                            for (Object obj1 : parser1) {
                                JSONObject User = (JSONObject) obj1;
                                String UsernameInsideDatabase2 = (String) User.get("Username");
                                if (username1.equals(UsernameInsideDatabase2)) {
                                    JSONObject studentModule = (JSONObject) User.get("Learning_Modules");

                                    for (Object key : studentModule.keySet()) { //key = {dmt, imt, oodj...}
                                        String keyStr=(String) key;
                                        if(keyStr.equals("OODJ")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("OODJ");
                                            System.out.println("Marks of Module OODJ");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                        else if(keyStr.equals("PSMOD")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("PSMOD");
                                            System.out.println("Marks of Module PSMOD");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                        else if(keyStr.equals("DTM")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("DTM");
                                            System.out.println("Marks of Module DTM");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                        else if(keyStr.equals("IMT")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("IMT");
                                            System.out.println("Marks of Module IMT");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                        else if(keyStr.equals("MCFC")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("MCFC");
                                            System.out.println("Marks of Module MCFC");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                        else if(keyStr.equals("COMT")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("COMT");
                                            System.out.println("Marks of Module COMT");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                        else if(keyStr.equals("CITW")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("CITW");
                                            System.out.println("Marks of Module CITW");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                        else if(keyStr.equals("SDM")){
                                            JSONObject oneModule=(JSONObject) studentModule.get("SDM");
                                            System.out.println("Marks of Module SDM");
                                            String oneMark1 = (String) oneModule.get("Assignment");
                                            String oneMark2 = (String) oneModule.get("Quiz");
                                            String oneMark3 = (String) oneModule.get("Lab Test");
                                            System.out.println("Assignment is "+oneMark1);
                                            System.out.println("Quiz is "+oneMark2);
                                            System.out.println("Lab Test is "+oneMark3);
                                        }
                                    }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }               
                    } else if (choice1 == 2) {
                        counter1 = false;
                    } else {
                        System.out.print("Oops! Something went wrong, Please try again!");
                    }
                }
                break;

        }
    }
}
