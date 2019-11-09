import java.util.Scanner;

public class Main {

    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int choice;
        Ticket t;

        Layout.start();
        
        do{
            Layout.clearScreen();
            Layout.displayEstelle();

            System.out.println("1. Book a ticket.");
            System.out.println("__________________________");
            System.out.println();
            
            System.out.println("2. Cancel a booking.");
            System.out.println("__________________________");
            System.out.println();

            System.out.println("3. Check out the movies coming soon to our screens.");
            System.out.println("_________________________________________________________");
            System.out.println();

            System.out.println("4. Exit.");
            System.out.println("______________");
            System.out.println();

            System.out.println("Enter your choice:");
            try {
                choice = Integer.parseInt(in.nextLine());
            }
            catch(NumberFormatException e) {
                choice = 0;
            }

	        switch(choice){
                case 1:
                    t = new Ticket();
                    t.bookTicket();
                    break;

                case 2:
                    t = new Ticket();
                    t.cancelTicket();
                    break;

                case 3:
                    Layout.clearScreen();
                    Layout.displayEstelle();
                    System.out.println("Coming soon.");
                    System.out.println("________________");
                    System.out.println();
                    Layout.print(Movies.comingSoon());
                    System.out.println("Press Enter to go back to the main menu. ");
                    in.nextLine();
                    break;

                case 4:
                    Layout.exit();
                    break;
                
                default:
                    break;
            }
        } while (choice != 4);
        in.close();
    }
}