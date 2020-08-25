/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;

/**
 *
 * @author User
 */
public class Register_Main {

    /**
     */
    public void Register_Main() {
        File f = new File(Main.databasepath);
        if (f.exists()) {
            System.out.println("Database Exists");
            System.out.println("Updating database...");
            Register_File_Append newreg = new Register_File_Append();
            newreg.Register();
            System.out.println("Saved Succcessfully");

        } else {
            System.out.println("Database Doesnt Exists");
            System.out.println("Creating database...");
            Register_File_CreateNewFile newreg = new Register_File_CreateNewFile();
            newreg.Register();
            System.out.println("Saved Succcessfully");

        }
    }
}
