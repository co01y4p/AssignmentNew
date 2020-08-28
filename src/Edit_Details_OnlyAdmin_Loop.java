
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
                        JSONObject User = (JSONObject) o;
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        if (credUserName.equals(Username) && credPwd.equals(Pwd)) {
                            User.put("Name", newVal);
                            FileWriter file = new FileWriter(Main.databasepath);
                            file.write(a.toJSONString());
                            file.flush();
                            file.close();
                            
                        }
                    }
                    System.out.println("Name Updated Successfully");
                    break;
                case 2:
                    for (Object o : a) {
                        JSONObject User = (JSONObject) o;
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        if (credUserName.equals(Username) && credPwd.equals(Pwd)) {
                            User.put("Username", newVal);
                            FileWriter file = new FileWriter(Main.databasepath);
                            file.write(a.toJSONString());
                            file.flush();
                            file.close();
                            
                        }
                    }
                    System.out.println("Username Updated Successfully");
                    break;
                case 3:
                    for (Object o : a) {
                        JSONObject User = (JSONObject) o;
                        String Username = (String) User.get("Username");
                        String Pwd = (String) User.get("Password");
                        if (credUserName.equals(Username) && credPwd.equals(Pwd)) {
                            User.put("Password", newVal);
                            FileWriter file = new FileWriter(Main.databasepath);
                            file.write(a.toJSONString());
                            file.flush();
                            file.close();
                           
                        }
                    }
                    System.out.println("Password Updated Successfully");
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