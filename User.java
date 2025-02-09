import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.Console;

public class User {
    private String mail_id, username, password;
    private long ph_no;
    Console cnsle = System.console();

    public final Scanner scan = new Scanner(System.in);

    public String getMail_id() {
        return mail_id;
    }

    public long getPh_no() {
        return ph_no;
    }

    public void setPh_no(long ph_no) {
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

    public boolean auth(String username, String password) throws IOException {
        File f = new File("./Accounts.txt");
        FileInput in = new FileInput(f);
        String[] data;
        String[] temp;
        do {
            if(!in.ready()) {
                break;
            }
            data = in.readline().trim().split(" ");
            for(int i=0; i<data.length; i++) {
                temp = data[i].trim().split("[:]");
                
                switch(temp[0]) {
                    case "Username":
                        setUsername(temp[1]);
                        break;
                    case "PhoneNo":
                        setPh_no(Long.parseLong(temp[1]));
                        break;
                    case "MailId":
                        setMail_id(temp[1]);
                        break;
                    case "Password":
                        setPassword(temp[1]);
                        break;
                }
            }
        }while(!getUsername().equals(username) || !getPassword().equals(password));
        in.close();
        if(getUsername().equals(username) && getPassword().equals(password)) {
            return true;
        }
        else {
            this.username = null;
            this.mail_id = null;
            this.password = null;
            this.ph_no = 0;
            return false;
        }
    }

    public boolean login() throws IOException {
        Layout.clearScreen();
        Layout.displayEstelle();
        
        System.out.println("Login.");
        System.out.println("____________");
        
        System.out.println();
        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        
        System.out.println();
        System.out.print("Enter your password: ");
        char pwd[] = cnsle.readPassword();
        String password = new String(pwd);
        if(auth(username, password)) {
            System.out.println();
            System.out.println("Login successful!");
            System.out.println();
            return true;
        }
        else {
            System.out.println();            
            System.out.println("Login failed! Login again? [y/n]");
            char choice = scan.nextLine().charAt(0);
            if(choice == 'y') {
                return login();
            }
            else {
                System.out.println();
                System.out.print("Sign up instead? [y/n]");
                choice = scan.nextLine().charAt(0);
                if(choice == 'y') {
                    return signUp();
                }
                else {
                    return false;
                }
            }
        }
    }

    public boolean signUp() throws IOException {
		Layout.clearScreen();
		Layout.displayEstelle();
		
		File f = new File("./Accounts.txt");
		
		
		FileInput in = new FileInput(f);
		String s = "";
		char c;
        while(in.ready()) {
            c = (char)in.read();
            s = s.concat(String.valueOf(c));
        }
		in.close();
		
        String[] str = s.trim().split("\n");
        String username;
		System.out.println("Create new account.");
        System.out.println("_________________________");
        do {
            System.out.println();
            System.out.print("Enter your username: ");
            username = scan.nextLine();
            for(int i=0; i<str.length; i++) {
                if(str[i].split(" ")[0].equals("Username:".concat(username))) {
                    System.out.println();
                    System.out.println("Username already exists! Please try a different username.");
                    username = null;
                    break;
                }
            }
            setUsername(username);
        }while(this.username == null);
        
        int error;
        
        do {
            System.out.println();
            System.out.print("Enter your phone number: ");
            error = 0;
            try {
                setPh_no(Long.parseLong(scan.nextLine()));
            }
            catch(NumberFormatException e) {
                error = 1;
            }
        }while(error == 1);

        System.out.println();
        System.out.print("Enter your e-mail: ");
        setMail_id(scan.nextLine());
        
        String password, confPass;
        System.out.println();
        System.out.print("Enter your password: ");
        char pwd1[] = cnsle.readPassword();
        password = new String(pwd1);
        
        do {
            System.out.print("Re-enter your password for confirmation: ");
            pwd1 = cnsle.readPassword();
            confPass = new String(pwd1);
            if (password.equals(confPass))
                setPassword(password);
            else {
                System.out.println();
                System.out.println("Passwords do not match! Please try again.");
                System.out.println();
            }
        } while (!password.equals(confPass));

        FileWriter writer = new FileWriter(f);
		writer.write(s + "\n");
        writer.append("Username:"+this.username+" "+"PhoneNo:"+this.ph_no+" "+"MailId:"+this.mail_id+" "+"Password:"+this.password);
        writer.close();
        return true;
    }
}
