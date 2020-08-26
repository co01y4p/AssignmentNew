
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Edit_Details_OnlyAdmin_Loop {
    public static void Edit_Details_OnlyAdmin_Loop(int Option, String newVal, String credUserName, String credPwd) {
        try {
            JSONParser parser = new JSONParser();


            JSONArray a = (JSONArray) parser.parse(new FileReader(Main.databasepath));
//System.out.println("a is"+a);

            switch (Option) {
                case 1:

                    for (Object o : a) {
                        //System.out.println("o is"+o);

                        JSONObject User = (JSONObject) o;
                        // System.out.println("user is:" + User);

                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        JSONObject new1= (JSONObject) User.get("Name");
                        if (credUserName.equals(Username) && credPwd.equals(Pwd)) {
                            //JSONObject EditDetails =(JSONObject)User;
                            //System.out.println("EditDetails is"+EditDetails);

                            // JSONObject EditDetails = new JSONObject();
                            new1.put("Name", newVal);

                        }

                    }
                    break;
                case 2:
                    for (Object o : a) {
                        JSONObject User = (JSONObject) o;
                        // fixed attributes: programme,
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        // String Role = (String) User.get("Role");

                        if (credUserName.equals(Username) && credPwd.equals(Pwd)) {
                            JSONObject EditDetails = new JSONObject();
                            // EditDetails.remove("Username");
                            EditDetails.put("Username", newVal);

                        }

                    }
                    break;
                case 3:
                    for (Object o : a) {
                        JSONObject User = (JSONObject) o;
                        // fixed attributes: programme,
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        // String Role = (String) User.get("Role");

                        if (credUserName.equals(Username) && credPwd.equals(Pwd)) {
                            JSONObject EditDetails = new JSONObject();
                            EditDetails.remove("Password");
                            EditDetails.put("Password", newVal);

                        }

                    }
                    break;

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