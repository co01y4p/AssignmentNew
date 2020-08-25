


import java.io.*;

class User {
    private String username, password,usertype;
    public User(){}
    public User(String username, String password, String usertype){
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    private void UserAdd(String userN, String passW, String userT){
        User user1 = new User();
        this.username =  userN;
        this.password = passW;
        this.usertype = userT;
    }
        public void User2File(){
        File FInput = new File("UserData.txt");
        try{
            FileWriter fw = new FileWriter(FInput,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw= new PrintWriter(FInput);
            String Line = username + " " + password;
            bw.newLine();
            pw.print(Line);
            pw.close();
            }    
        catch(IOException Ex){
        }
    }

}
