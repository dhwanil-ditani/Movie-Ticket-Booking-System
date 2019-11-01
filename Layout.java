public class Layout {

    public static void exit() throws InterruptedException {
        clearScreen();
        System.out.println("Exiting...............");
        processBar();
        clearScreen();
    }

    public static void start() throws InterruptedException {
        clearScreen();
        System.out.println("Estelle");
        System.out.println("Loading:");
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
            Thread.sleep(50);
            System.out.print("\r");
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
