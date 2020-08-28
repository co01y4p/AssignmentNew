import java.util.ArrayList;

import java.util.Scanner;

public class Register_File_Input_Teaching_Modules {
    public ArrayList<String> moduleTeachingList() {
        Scanner ipt = new Scanner(System.in);
        ArrayList<String> moduleList = new ArrayList<>();
        moduleList.add("OODJ");
        moduleList.add("PSMOD");
        moduleList.add("DTM");
        moduleList.add("IMT");
        moduleList.add("MCFC");
        moduleList.add("COMT");
        moduleList.add("CITW");
        moduleList.add("SDM");
        ArrayList<String> modulePickedList = new ArrayList<>();
        System.out.println("Please Enter the Lecturer's Teachings ");
        System.out.println("1. OODJ     2. PSMOD");
        System.out.println("3. DTM      4. IMT");
        System.out.println("5. MCFC     6. COMT");
        System.out.println("7. CITW     8. SDM");

        System.out.println("First Teaching Module: ");
        int inp_Option = ipt.nextInt();
        System.out.println(moduleList.get(inp_Option - 1));

        modulePickedList.add(moduleList.get(inp_Option - 1));

        System.out.println("Second Teaching Module: ");
        int inp_Option2 = ipt.nextInt();
        modulePickedList.add(moduleList.get(inp_Option2 - 1));

        System.out.println("Third Teaching Module: ");
        int inp_Option3 = ipt.nextInt();
        modulePickedList.add(moduleList.get(inp_Option3 - 1));

        ipt.close();
        return (modulePickedList);
    }

}
