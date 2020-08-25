/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Scanner;
import org.json.simple.JSONObject;

public class Register_File_Append {

    /**
     */
    public void Register() {
        JSONObject registerNewUserDetails = new JSONObject();
        JSONParser jsonParser = new JSONParser();

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
        else if (tempRole.equals("")) {//Lecturer
            Register_File_Input_Programme newObj2 = new Register_File_Input_Programme();
            registerNewUserDetails.put("Programme", String.valueOf(newObj2.main()));

            Register_File_Input_Module newObj3 = new Register_File_Input_Module();
            registerNewUserDetails.put("Module", String.valueOf(newObj3.main()));

            registerNewUserDetails.put("AssesType", "");

            registerNewUserDetails.put("Marks", "");
        }
        else {//Student
            Register_File_Input_Programme newObj2 = new Register_File_Input_Programme();
            registerNewUserDetails.put("Programme", String.valueOf(newObj2.main()));

            Register_File_Input_Module newObj3 = new Register_File_Input_Module();
            registerNewUserDetails.put("Module", String.valueOf(newObj3.main()));

            Register_File_Input_AssesType newObj4 = new Register_File_Input_AssesType();
            registerNewUserDetails.put("AssesType", String.valueOf(newObj4.main()));

            registerNewUserDetails.put("Marks", "");
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

    }
}
