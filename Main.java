import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int choice;
        Ticket t;

        Scanner in = new Scanner(System.in);

        Layout.start();
        System.out.println("0. Exit");
	    System.out.println("1. New Booking.");
	    System.out.println("2. Cancel Booking.");
	    System.out.println("3. Coming Soon.");
	    choice = in.nextInt();

	    switch(choice) {
            case 0:
                Layout.exit();
            case 1:
                t = new Ticket();
                t.bookTicket();
                break;
            case 2:
                t = new Ticket();
                t.cancelTicket();
                break;
            case 3:
                Movies.comingSoon();
            default:
                break;
        }
        in.close();
    }
}