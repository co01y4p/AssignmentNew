/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Student extends User {
    private String student_module, student_class, student_marks;
    public Student(String SUserName, String SPassword, String SSModule, String SClass, String SMarks){
        super(SUserName,SPassword);
        student_module = SSModule;
        student_class = SClass;
        student_marks = SMarks;  
    }        
}
