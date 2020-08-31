import java.util.ArrayList;
import java.util.Scanner;



public class Register_File_Input_Cohorts {

    public String studentCohort() {

        
            Scanner ipt2 = new Scanner(System.in);
            ArrayList<String> cohortsList = new ArrayList<>();
            cohortsList.add("APU2F2006CSDA");
            cohortsList.add("UCF2F2006CSDA");
            cohortsList.add("APU2F2006CS");
            cohortsList.add("UCF2F2006CS");
            cohortsList.add("APU2F2006CSIS");
            cohortsList.add("UCF2F2006CSIS");
            cohortsList.add("APU2F2006IT");
            cohortsList.add("UCF2F2006IT");
            System.out.println("Cohorts available");
            System.out.println("1. APU2F2006CSDA    2. UCF2F2006CSDA");
            System.out.println("3. APU2F2006CS      4. UCF2F2006CS");
            System.out.println("5. APU2F2006CSIS    6. UCF2F2006CSIS");
            System.out.println("7. APU2F2006IT      8. UCF2F2006IT");
            System.out.println("Please Enter His Cohorts: ");
            int inpOpt = ipt2.nextInt();
            String cohortPicked=cohortsList.get(inpOpt - 1);
           
        return (cohortPicked);

    }
}