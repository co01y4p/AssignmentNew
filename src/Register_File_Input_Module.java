/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class Register_File_Input_Module {

    public int main() {
        int counter2 = 100;
        int passingModule = 0;
        Scanner inputRegister = new Scanner(System.in);

        while (counter2 < 101) {
            System.out.println("Please Enter his Module: ");
            System.out.println("1. OODJ");
            System.out.println("2. DTM");

            int inp_Module = inputRegister.nextInt();

            if (inp_Module < 3) {

                passingModule = inp_Module;
                counter2 = 102;

            } else {
                System.out.println("Invalid Module input, please try again!");

            }
        }
        return passingModule;
    }
}
