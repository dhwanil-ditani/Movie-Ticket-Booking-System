import java.util.Scanner;

public class Ticket {

    String movieName;
    String movieTime;
    String seatNumber;
    double moviePrice;

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
        System.out.println("Invalid Entry!");
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
        System.out.println("Invalid Entry!");
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
        System.out.println("Now Showing Movies");
        Layout.print(Movies.nowShowing());
        System.out.flush();
        Scanner input = new Scanner(System.in);
        String choice;
        do{
            System.out.print("Select the Movie: ");
            choice = input.nextLine();
        }while(!setMovieName(choice));
        Layout.clearScreen();
        System.out.println("Movie: " + getMovieName());
        Layout.print(Movies.timings(getMovieName()));
        System.out.print("Select the time: ");
        do{
            choice = input.nextLine();
        }while(!setMovieTime(choice));
        System.out.println("Movie: " + getMovieName());
        System.out.println("Time: " + getMovieTime());
        input.close();
    }

    void cancelTicket(){

    }
}