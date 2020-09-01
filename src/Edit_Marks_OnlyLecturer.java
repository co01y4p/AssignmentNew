import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



class Edit_Marks_OnlyLecturer {
    
    boolean counter2 = true;

    public void main() {
        Scanner inp = new Scanner(System.in);
        boolean counter1 = false;

        try {
            JSONParser parser = new JSONParser();
            JSONArray allusers = (JSONArray) parser.parse(new FileReader(Main.databasepath));

            while (counter1 == false) {
                System.out.println("Greetings, Lecturer");
                System.out.println("1. Update Student's Marks");
                System.out.println("2. Exit");
                System.out.println("Enter your choice");
                int choice1 = inp.nextInt();
                if (choice1 == 1) {
                    System.out.println("Please Enter Student's Username: ");
                    String inp_username = inp.next();

                    for (Object o : allusers) {

                        JSONObject whichUser = (JSONObject) o;

                        String Username = (String) whichUser.get("Username");
                        String Name = (String) whichUser.get("Name");

                        if (inp_username.equals(Username)) {
                            System.out.println("Hooray, Student Exist!");
                            System.out.println("Student's Name: " + Name);
                            JSONObject whichUserAllLModule = (JSONObject) whichUser.get("Learning_Modules");

                            System.out.println("Student " + Name + " having following modules:");
                            for (Object key : whichUserAllLModule.keySet()) {
                                // based on you key types
                                String keyStr = (String) key;
                                // Print key
                                System.out.println("Module " + keyStr);
                            }

                            // System.out.println("1. OODJ 2. PSMOD");
                            // System.out.println("3. DTM 4. IMT");
                            // System.out.println("5. MCFC 6. COMT");
                            // System.out.println("7. CITW 8. SDM");

                            System.out.println("Please enter the module code to be updated:");
                            int moduleCodeInput = inp.nextInt();

                            ArrayList<String> moduleList = new ArrayList<>();
                            moduleList.add("OODJ");
                            moduleList.add("PSMOD");
                            moduleList.add("DTM");
                            moduleList.add("IMT");
                            moduleList.add("MCFC");
                            moduleList.add("COMT");
                            moduleList.add("CITW");
                            moduleList.add("SDM");
                            System.out.println("You are about to edit the marks of student " + Name + "'s " + "module "
                                    + moduleList.get(moduleCodeInput - 1));
                            System.out.println("Please choose assessment type to have the mark updated:");
                            System.out.println("1.Quiz(10%)   2.LabTest(40%)   3.Assignment(50%)");
                            System.out.println("Please enter the assessment code to be updated:");
                            int assesCodeInput = inp.nextInt();

                            ArrayList<String> showAssesList = new ArrayList<>();
                            showAssesList.add("Quiz(10%)");
                            showAssesList.add("LabTest(40%)");
                            showAssesList.add("Assignment(50%)");
                            System.out.println("Please enter the marks of " + showAssesList.get(assesCodeInput - 1)
                                    + " to be updated:");
                            String marksEntered = inp.next();
                            FileWriter file = new FileWriter(Main.databasepath);

                            while (counter2 == true) {
                                switch (moduleCodeInput) {
                                    case 1:
                                        JSONObject whichModule1 = (JSONObject) whichUserAllLModule.get("OODJ");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule1.put("Quiz", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 2:
                                                whichModule1.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule1.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:
                                                System.out.println("Oops, something went wrong!");

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();

                                        break;
                                    case 2:
                                        JSONObject whichModule2 = (JSONObject) whichUserAllLModule.get("PSMOD");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule2.put("Quiz", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 2:
                                                whichModule2.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule2.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:
                                                System.out.println("Oops, something went wrong!");

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();
                                        break;
                                    case 3:
                                        JSONObject whichModule3 = (JSONObject) whichUserAllLModule.get("DTM");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule3.put("Quiz", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 2:
                                                whichModule3.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule3.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:
                                                System.out.println("Oops, something went wrong!");

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();
                                        break;
                                    case 4:
                                        JSONObject whichModule4 = (JSONObject) whichUserAllLModule.get("IMT");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule4.put("Quiz", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 2:
                                                whichModule4.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule4.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:
                                                System.out.println("Oops, something went wrong!");

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();
                                        break;
                                    case 5:
                                        JSONObject whichModule5 = (JSONObject) whichUserAllLModule.get("MCFC");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule5.put("Quiz", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 2:
                                                whichModule5.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule5.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:
                                                System.out.println("Oops, something went wrong!");

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();
                                        break;
                                    case 6:
                                        JSONObject whichModule6 = (JSONObject) whichUserAllLModule.get("CITW");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule6.put("Quiz", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 2:
                                                whichModule6.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule6.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:
                                                System.out.println("Oops, something went wrong!");

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();
                                        break;
                                    case 7:
                                        JSONObject whichModule7 = (JSONObject) whichUserAllLModule.get("SDM");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule7.put("Quiz", marksEntered);
                                                counter1 = true;
                                                counter2 = false;
                                                break;
                                            case 2:
                                                whichModule7.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule7.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:
                                                System.out.println("Oops, something went wrong!");

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();
                                        break;
                                    case 8:
                                        JSONObject whichModule8 = (JSONObject) whichUserAllLModule.get("IMT");
                                        switch (assesCodeInput) {
                                            case 1:
                                                whichModule8.put("Quiz", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 2:
                                                whichModule8.put("LabTest", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            case 3:
                                                whichModule8.put("Assignment", marksEntered);
                                                counter2 = false;
                                                counter1 = true;
                                                break;
                                            default:

                                        }
                                        file.write(allusers.toJSONString());
                                        file.flush();
                                        file.close();
                                        break;
                                    default:
                                        System.out.println("Oops, something went wrong!");

                                        break;

                                }
                            }

                        }
                    }

                    if (counter1 == false) {
                        System.out.println("Invalid Username, please try again");
                    } // coun1 == true
                } else if (choice1 == 2) {
                    counter1 = true;

                    // go to exit
                }

                System.out.println("Updated Successfully");

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