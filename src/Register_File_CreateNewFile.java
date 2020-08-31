
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;

import org.json.simple.JSONArray;

class Register_File_CreateNewFile {

    public void Register() {

        HashMap<String, Object> registerNewUserDetails = new HashMap<String, Object>();

        Scanner inputRegister = new Scanner(System.in);
        System.out.println("Welcome to Registration!");

        System.out.println("Please Enter Name: ");
        String inp_name = inputRegister.nextLine();
        registerNewUserDetails.put("Name", inp_name);

        System.out.println("Please Enter UserID: ");
        String inp_userID = inputRegister.nextLine();
        registerNewUserDetails.put("Username", inp_userID);

        System.out.println("Please Enter Password: ");
        String inp_password = inputRegister.nextLine();
        registerNewUserDetails.put("Password", inp_password);

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

        //
        JSONArray registerNewUserList = new JSONArray();

        registerNewUserList.add(registerNewUserDetails);

        try (FileWriter file = new FileWriter(Main.databasepath)) {

            file.write(registerNewUserList.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occured");

        }
        inputRegister.close();
    }
}
