import java.util.Scanner;

public class Ticket {

    String movieName;
    String movieTime;
    String movieDate;
    String seatNumber;
    double moviePrice;
    User user;

    public final Scanner input = new Scanner(System.in);


    public String getMovieName() {
        return movieName;
    }

    public boolean setMovieName(int ch) throws Exception {
        String movies[] = Movies.nowShowing();
        for (int i = 0; i < movies.length; i++) {
            if ((ch+48) == movies[i].charAt(0)) {
                this.movieName = movies[i].substring(3);
                return true;
            }
        }
        System.out.println();
        System.out.println("Invalid Entry! Please try again.");
        System.out.println();
        return false;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public boolean setMovieTime(String movieTime) throws Exception {
        String[] timings;
        timings = Movies.timings(getMovieName());
        for(int i=0; i<timings.length; i++) {
            if(movieTime.equalsIgnoreCase(timings[i])) {
                this.movieTime = movieTime;
                return true;
            }
        }
        System.out.println();
        System.out.println("Invalid Entry! Please try again.");
        System.out.println();
        return false;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public boolean setMovieDate(char ch) throws Exception {
        String dates[] = Movies.dates();
        for (int i = 0; i < dates.length; i++) {
            if (ch == dates[i].charAt(0)) {
                movieDate = dates[i].substring(3);
                return true;
            }
        }
        System.out.println();
        System.out.println("Invalid Entry! Please try again.");
        System.out.println();
        return false;
    }
    
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(double moviePrice) {
        this.moviePrice = moviePrice;
    }

    void bookTicket() throws Exception {
        Layout.clearScreen();
        
        Layout.displayEstelle();
        System.out.println("Now Showing.");
        System.out.println("__________________");
        System.out.println();
        
        Layout.printMovies(Movies.nowShowing());

        
        String choice;
        char ch1;
        int ch2;
        
        do{
            System.out.println("Choose a movie: ");
            ch2 = Integer.parseInt(input.nextLine());
        } while (!setMovieName(ch2));
        
        Layout.clearScreen();
        
        Layout.displayEstelle();
        System.out.println("Showtimes for " + getMovieName() + ".");
        System.out.println("_____________________________________");
        System.out.println();

        Layout.print(Movies.dates());
        
        do{
            System.out.println("Choose your preferred date for " + getMovieName() + " (enter the alphabet corresponding to preferred date): ");
            ch1 = input.nextLine().charAt(0);
        } while (!setMovieDate(ch1));

        System.out.println();
        Layout.printST(Movies.timings(getMovieName()));
        System.out.println();
        System.out.println();

        do{
            System.out.println("Choose your preferred showtime for " + getMovieName() + ": ");
            choice = input.nextLine();
        } while (!setMovieTime(choice));
        
        Layout.clearScreen();
        Layout.displayEstelle();
        System.out.println("Tickets almost booked! Login or sign up to confirm the tickets.");
        System.out.println();
        
        try {
            user.auth(user.getUsername(), user.getPassword());
        }
        
        catch(NullPointerException e) {
            user = new User();
            System.out.println("1. Login.");
            System.out.println();
            System.out.println("2. Sign up.");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = input.nextLine();
            if(choice.equals("1")) {
                if(!user.login()) {
                    user = null;
                }
            }
            else if(choice.equals("2")) {
                user.signUp();
            }
            else {
                System.out.println("Invalid input, please try again!");
            }
        }

        Layout.clearScreen();
        Layout.displayEstelle();
        System.out.println("Payment.");
        System.out.println("_______________");
        System.out.println();
        System.out.println("1. Credit Card.");
        System.out.println();
        System.out.println("2. Debit Card.");
        System.out.println();
        System.out.println("Choose you preferred option:");
        ch2 = input.nextInt();
        
        if (ch2 == 1) {
            CreditCard cc = new CreditCard();
            cc.pay();
        }
        else {
            DebitCard dc = new DebitCard();
            dc.pay();
        }

        try {
            System.out.println("Booking confirmed :) Thank you for choosing Estelle!");
            System.out.println();
            Layout.print(user);
            System.out.println();
            System.out.println("Movie: " + getMovieName());
            System.out.println("Showtime: " + getMovieTime());
            System.out.println();
            System.out.println("Press Enter to go back to the main menu. ");
            input.nextLine();
        }
        
        catch(NullPointerException e) {
            System.out.println("Booking failed! :(");
            System.out.println();
            System.out.println("Press Enter to go back to the main menu. ");
            input.nextLine();
            Layout.processBar();
        }
    }

    void cancelTicket(){

    }
}
