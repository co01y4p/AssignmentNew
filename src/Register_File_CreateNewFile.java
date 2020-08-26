
import java.io.*;
import java.util.Scanner;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class Register_File_CreateNewFile {

    public void Register() {
        //double[] marksArray = {98,78,80};

        JSONObject registerNewUserDetails = new JSONObject();

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

        if (tempRole.equals("1")) {//Admin
            registerNewUserDetails.put("Programme", "");

            registerNewUserDetails.put("Module", "");

            registerNewUserDetails.put("AssesType", "");

            registerNewUserDetails.put("Marks", "");
        }
        else if (tempRole.equals("2")) {//Lecturer
            Register_File_Input_Programme newObj2 = new Register_File_Input_Programme();
            registerNewUserDetails.put("Programme", String.valueOf(newObj2.main()));

            Register_File_Input_Module newObj3 = new Register_File_Input_Module();
            registerNewUserDetails.put("Module", String.valueOf(newObj3.main()));

            registerNewUserDetails.put("AssesType", "");

            registerNewUserDetails.put("Marks", "");
        }
        else{//Student
            Register_File_Input_Programme newObj2 = new Register_File_Input_Programme();
            registerNewUserDetails.put("Programme", String.valueOf(newObj2.main()));

            Register_File_Input_Module newObj3 = new Register_File_Input_Module();
            registerNewUserDetails.put("Module", String.valueOf(newObj3.main()));

            Register_File_Input_AssesType newObj4 = new Register_File_Input_AssesType();
            registerNewUserDetails.put("AssesType", String.valueOf(newObj4.main()));

            registerNewUserDetails.put("Marks", "");
        }

//
        JSONArray registerNewUserList = new JSONArray();

        registerNewUserList.add(registerNewUserDetails);

        try ( FileWriter file = new FileWriter(Main.databasepath)) {

            file.write(registerNewUserList.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occured");

        }

    }
}
