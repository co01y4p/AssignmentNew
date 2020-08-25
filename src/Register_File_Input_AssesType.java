/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

public class Register_File_Input_AssesType {

    public int main() {
        int counter2 = 100;
        int passingAssesType = 0;
        Scanner inputRegister = new Scanner(System.in);

        while (counter2 < 101) {
            System.out.println("Please Enter the Assessment: ");
            System.out.println("1. Quiz (10%)");
            System.out.println("2. Lab Test (40%)");
            System.out.println("3. Assignment (50%)");
            int inp_AssesType = inputRegister.nextInt();

            if (inp_AssesType < 3) {

                passingAssesType = inp_AssesType;
                counter2 = 102;

            } else {
                System.out.println("Invalid Programme input, please try again!");

            }
        }
        return passingAssesType;
    }
}
