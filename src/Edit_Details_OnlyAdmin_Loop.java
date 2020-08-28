
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Edit_Details_OnlyAdmin_Loop {

    public void Edit_Details_OnlyAdmin_Loop_main(int Option, String newVal, String credUserName, String credPwd) {
        try {
            JSONParser parser = new JSONParser();

            JSONArray a = (JSONArray) parser.parse(new FileReader(Main.databasepath));
            // System.out.println("a is"+a);

            switch (Option) {
                case 1:

                    for (Object o : a) {
                        // System.out.println("o is"+o);

                        JSONObject User = (JSONObject) o;
                        // System.out.println("user is:" + User);

                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        // JSONObject new1= (JSONObject) User.get("Name");
                        if (credUserName.equals(Username) && credPwd.equals(Pwd)) {
                            // System.out.println(User.remove("Name"));
                            User.put("Name", newVal);
                            FileWriter file = new FileWriter(Main.databasepath);
                            file.write(a.toJSONString());
                            file.flush();
                            // System.out.println("updated successfully");

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