/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class Register_File_Input_Programme {

    public int main() {
        int counter2 = 100;
        int passingProgramme = 0;
        Scanner inputRegister = new Scanner(System.in);

        while (counter2 < 101) {
            System.out.println("Please Enter his Programme: ");
            System.out.println("1. Computer Science");
            System.out.println("2. Intelligent System");

            int inp_Programme = inputRegister.nextInt();

            if (inp_Programme < 3) {

                passingProgramme = inp_Programme;
                counter2 = 102;

            } else {
                System.out.println("Invalid Programme input, please try again!");

            }
        }
        return passingProgramme;
    }
}
