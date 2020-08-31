
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Register_File_Append {
    boolean counter1 = false;

    /**
     */
    public void Register() {
        HashMap<String, Object> registerNewUserDetails = new HashMap<String, Object>();
        JSONParser jsonParser = new JSONParser();

        Scanner inputRegister = new Scanner(System.in);
        System.out.println("Welcome to Registration!");

        System.out.println("Please Enter Name: ");
        String inp_name = inputRegister.nextLine();
        registerNewUserDetails.put("Name", inp_name);

        while (counter1 == false) {
            boolean counter2 = false;

            System.out.println("Please Enter UserID: ");
            String inp_userID = inputRegister.nextLine();
            registerNewUserDetails.put("Username", inp_userID);

            System.out.println("Please Enter Password: ");
            String inp_password = inputRegister.nextLine();
            registerNewUserDetails.put("Password", inp_password);

            try {
                JSONParser parser = new JSONParser();
                JSONArray a = (JSONArray) parser.parse(new FileReader(Main.databasepath));
                for (Object o : a) {
                    JSONObject User = (JSONObject) o;
                    String Username = (String) User.get("Username");
                    String Pwd = (String) User.get("Password");
                    if (inp_userID.equals(Username) && inp_password.equals(Pwd)) {
                        counter2 = true;
                        break;
                    }
                }
                if (counter2 == true) {
                    System.out.println("Duplicated Username or Password!");
                    System.out.println("Please try again!");
                }
                if (counter2 == false) {
                    counter1 = true;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Register_File_Input_Role newObj = new Register_File_Input_Role();
        String tempRole = String.valueOf(newObj.main());
        registerNewUserDetails.put("Role", tempRole);

        if (tempRole.equals("1")) {// Admin
            registerNewUserDetails.put("Teachings_Modules", "");

            registerNewUserDetails.put("Learning_Modules", "");
            registerNewUserDetails.put("Cohorts","");

        } else if (tempRole.equals("2")) {// Lecturer
            Register_File_Input_Teaching_Modules teachingObj = new Register_File_Input_Teaching_Modules();
            registerNewUserDetails.put("Teaching_Modules", teachingObj.moduleTeachingList());
            registerNewUserDetails.put("Learning_Modules", "");
            registerNewUserDetails.put("Cohorts","");

        } else {// Student
            registerNewUserDetails.put("Teaching_Modules", "");
            Register_File_Input_Learning_Modules_Names learningObj = new Register_File_Input_Learning_Modules_Names();
            registerNewUserDetails.put("Learning_Modules", learningObj.moduleLearningList());
            Register_File_Input_Cohorts newCo = new Register_File_Input_Cohorts();
            registerNewUserDetails.put("Cohorts",newCo.studentCohort());

        }

        try {
            Object obj = jsonParser.parse(new FileReader(Main.databasepath));
            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.add(registerNewUserDetails);

            FileWriter file = new FileWriter(Main.databasepath);
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        inputRegister.close();

    }
}
