import java.io.File;
import java.util.Scanner;

public class User {
    private String mail_id, ph_no, username, password;

    public String getMail_id() {
        return mail_id;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean auth(String username, String password) throws Exception {
        File f = new File("./Accounts.txt");
        FileInput in = new FileInput(f);
        String[] data;
        String[] temp;
        do {
            data = in.readline().trim().split(" ");
            for(int i=0; i<data.length; i++) {
                temp = data[i].trim().split("[:]");
                
                switch(temp[0]) {
                    case "Username":
                        setUsername(temp[1]);
                    case "PhoneNo":
                        setPh_no(temp[1]);
                    case "MailId":
                        setMail_id(temp[1]);
                    case "Password":
                        setPassword(temp[1]);
                }
            }
        }while(getUsername() != username || getPassword() != password);
        in.close();
        return true;
    }

    public void login() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = in.nextLine();
        System.out.print("Enter your password: ");
        String password = in.nextLine();
        auth(username, password);
        in.close();
    }

    public void signup() {
        
    }
}