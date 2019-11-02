import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int choice;
        Ticket t;

        Scanner in = new Scanner(System.in);

        Layout.start();
        
        //do{
            Layout.displayEstelle();

            System.out.println("1. Booking a ticket.");
            System.out.println("__________________________");
            System.out.println();
            
            System.out.println("2. Cancel a booking.");
            System.out.println("__________________________");
            System.out.println();

            System.out.println("3. Check out the movies coming soon.");
            System.out.println("__________________________________________");
            System.out.println();

            System.out.println("4. Exit.");
            System.out.println("______________");
            System.out.println();

	        choice = in.nextInt();

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
                    Layout.print(Movies.comingSoon());
                    break;

                case 4:
                    Layout.exit();
                    break;
                
                default: 
                    System.out.println("Invalid Entry! Please try again.");
                    System.out.println();
                    break;
            }
        //} while (choice > 0 && choice < 5);
        in.close();
    }
}