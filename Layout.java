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
                if( j <= i)
                    System.out.print("*");
                else
                    System.out.print("-");
            }
            System.out.print("]");
            Thread.sleep(25);
            System.out.print("\r");
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
        System.out.println("Name: "+user.getUsername());
        System.out.println("Ph_no: "+user.getPh_no());
        System.out.println("MailId: "+user.getMail_id());
    }
}
