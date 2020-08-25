

import java.util.Scanner;

public class Register_File_Input_Role {

    public int main() {
        int counter1 = 4;
        int passingRole = 0;
        Scanner inputRegister = new Scanner(System.in);

        while (counter1 > 3) {
            System.out.println("Please Enter Role: ");
            System.out.println("1. Admin");
            System.out.println("2. Lecturer");
            System.out.println("3. Student");
            System.out.println("Choice: ");
            int inp_role = inputRegister.nextInt();
            if (inp_role < 4) {
                passingRole = inp_role;
                counter1 = 0;

            } else {
                System.out.println("Invalid Role input, please try again!");
            }
        }
        return passingRole;

    }
}
