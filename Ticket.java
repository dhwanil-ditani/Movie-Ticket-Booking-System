import java.util.Scanner;

public class Ticket{
    
    String movieName;
    String movieTime;
    String seatNumber;
    double moviePrice;

    public String getMovieName() {
        return movieName;
    }

    public boolean setMovieName(String movieName) throws Exception {
        String movies[] = Movies.nowShowing();
        for(int i=0; i<movies.length; i++) {
            if(movieName.equalsIgnoreCase(movies[i])) {
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

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
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
        System.out.println("Now Showing Movies");
        Layout.print(Movies.nowShowing());
        Scanner input = new Scanner(System.in);
        String choice;
        do{
            System.out.print("Select the Movie: ");
            choice = input.nextLine();
            System.out.flush();
        }while(!setMovieName(choice));
        Layout.clearScreen();
        System.out.println("Movie: " + getMovieName());

        //Layout.print(Movies.timings(choice));
        //System.out.print("Select the time: ");
        //do{
        //    choice = input.nextLine();
        //}while(!setMovieTime(choice));
        input.close();
    }

    void cancelTicket(){

    }
}