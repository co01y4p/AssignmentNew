import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class Register_File_Input_Learning_Modules_Names {
    public JSONObject moduleLearningList(){
        Scanner ipt = new Scanner(System.in);
        JSONObject studentModuleSmall = new JSONObject();

        ArrayList<String> moduleList = new ArrayList<>();
        moduleList.add("OODJ");
        moduleList.add("PSMOD");
        moduleList.add("DTM");
        moduleList.add("IMT");
        moduleList.add("MCFC");
        moduleList.add("COMT");
        moduleList.add("CITW");
        moduleList.add("SDM");
        System.out.println("Please Enter the Student's Modules ");
        System.out.println("1. OODJ     2. PSMOD");
        System.out.println("3. DTM      4. IMT");
        System.out.println("5. MCFC     6. COMT");
        System.out.println("7. CITW     8. SDM");
        Register_File_Input_Learning_Modules_Marks marksDetails= new Register_File_Input_Learning_Modules_Marks();

        System.out.println("First Learning Module: ");
        int inp_Option = ipt.nextInt();
        studentModuleSmall.put(moduleList.get(inp_Option - 1), marksDetails.moduleLearningList());

        System.out.println("Second Learning Module: ");
        int inp_Option2 = ipt.nextInt();
        studentModuleSmall.put(moduleList.get(inp_Option2 - 1), marksDetails.moduleLearningList());

        System.out.println("Third Learning Module: ");
        int inp_Option3 = ipt.nextInt();
        studentModuleSmall.put(moduleList.get(inp_Option3 - 1), marksDetails.moduleLearningList());
        
        ipt.close();
        return (studentModuleSmall);
    }
}