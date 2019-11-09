import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Layout {
    public static void displayEstelle(){
        System.out.println("███████╗███████╗████████╗███████╗██╗     ██╗     ███████╗");
        System.out.println("██╔════╝██╔════╝╚══██╔══╝██╔════╝██║     ██║     ██╔════╝");
        System.out.println("█████╗  ███████╗   ██║   █████╗  ██║     ██║     █████╗  ");
        System.out.println("██╔══╝  ╚════██║   ██║   ██╔══╝  ██║     ██║     ██╔══╝  ");
        System.out.println("███████╗███████║   ██║   ███████╗███████╗███████╗███████╗");
        System.out.println("╚══════╝╚══════╝   ╚═╝   ╚══════╝╚══════╝╚══════╝╚══════╝");
        System.out.println();
    }

    public static void exit() throws InterruptedException {
        clearScreen();
        displayEstelle();
        System.out.println("Exiting....");
        processBar();
        clearScreen();
    }

    public static void start() throws InterruptedException {
        clearScreen();
        displayEstelle();
        System.out.println("Loading...");
        processBar();
        clearScreen();
    }

    public static void processBar() throws InterruptedException {
        for(int i = 0; i<50; i++)
        {
            System.out.print("[");
            for(int j = 0; j<50; j++)
            {
                if(j <= i)
                    System.out.print("*");
                else
                    System.out.print("-");
            }
            System.out.print("]");
            Thread.sleep(25);
            System.out.print("\r");
        }
    }
    
    public static void process() {
        char ani[] = {'|', '/', '-', '\\'};
        
        for(int i = 0; i<20; i++)
        {
            System.out.print("Processing payment...  ["+ ani[i % 4] + "]\r");
            
            try {
                Thread.sleep(200);
            } 
            
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void print(String[] str) {
        for(int i=0; i<str.length; i++) {
            System.out.println(str[i]);
            System.out.println();
        }
    }

    public static void print(User user) throws NullPointerException {
        System.out.println("Name: " + user.getUsername());
        System.out.println("Phone number: " + user.getPh_no());
        System.out.println("E-mail ID: " + user.getMail_id());
    }

    public static void printMovies(String[] str) {
        for(int i=0; i<str.length; i++) {
            System.out.println(str[i]);

            if (i > 0 && (i+1) % 4 == 0 || (i == 0 || i % 4 == 0))
                System.out.println();
        }
    }

    public static void printST(String[] str) {
        for(int i=0; i<str.length; i++) {
            System.out.print(str[i] + "    ");
        }
    }

    public static void printSeats(String movie) throws IOException {
        File f = new File("./seats.txt");
        FileReader reader = new FileReader(f);
        char c;
        int i = 0;

        while (reader.ready()) {
            i++;
            
            c = (char)reader.read();
            
            if(c == '□') {
                System.out.print("*");
            }
            
            else {
                System.out.print(c);
            }
        }
        reader.close();
    }
}
