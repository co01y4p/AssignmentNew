/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.naming.RefAddr;

public class Register_CheckExistence {

    public void main() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(Main.databasepath)){

            Object obj  = parser.parse(reader);
            JSONArray array = new JSONArray();
            array.add(obj);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    private static void parseEmployeeObject(JSONObject user)
    {
        //Get employee object within list
        JSONObject person = (JSONObject) user;

        String name = (String) person.get("Name");
        System.out.println(name);

        String id = (String) person.get("UserID");
        System.out.println(id);

        String pwd = (String) person.get("Password");
        System.out.println(pwd);

        JSONArray usr = (JSONArray) person.get("User");

        for (Object c : usr) {
            System.out.println(c + "");
    }
}
}
