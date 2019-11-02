import java.util.Scanner;

public class Ticket {

    String movieName;
    String movieTime;
    String seatNumber;
    double moviePrice;
    User user;

    public String getMovieName() {
        return movieName;
    }

    public boolean setMovieName(String movieName) throws Exception {
        String movies[] = Movies.nowShowing();
        for (int i = 0; i < movies.length; i++) {
            if (movieName.equalsIgnoreCase(movies[i])) {
                this.movieName = movieName;
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
        
        Layout.print(Movies.nowShowing());
        
        Scanner input = new Scanner(System.in);
        String choice;
        
        do{
            System.out.print("Choose a movie: ");
            choice = input.nextLine();
        } while (!setMovieName(choice));
        
        Layout.clearScreen();
        
        Layout.displayEstelle();
        System.out.println("Showtimes for " + getMovieName() + ".");
        System.out.println("_____________________________________");
        System.out.println();

        Layout.print(Movies.timings(getMovieName()));
        
        do{
            System.out.print("Choose your preferred showtime for " + getMovieName() + ": ");
            choice = input.nextLine();
        } while (!setMovieTime(choice));
        
        Layout.clearScreen();
        
        Layout.displayEstelle();
        System.out.println("Tickets booked! Thank you for choosing Estelle!");
        System.out.println("Movie: " + getMovieName());
        System.out.println("Showtime: " + getMovieTime());
        System.out.print("\n\n");
        Layout.processBar();
        
        try {
            user.auth(user.getUsername(), user.getPassword());
        }
        catch(NullPointerException e) {
            user = new User();
            if(!user.login()) {
                user = null;
            }
        }
        try {
            Layout.print(user);
            System.out.println("Movie: " + getMovieName());
            System.out.println("Showtime: " + getMovieTime());
        }
        catch(NullPointerException e) {
            System.out.println("Booking Failed");
        }

        input.close();
    }

    void cancelTicket(){

    }
}