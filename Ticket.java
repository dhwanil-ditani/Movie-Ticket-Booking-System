import java.util.Scanner;
public class Ticket{
    
    String movieName;
    String movieTime;
    String seatNumber;
    double moviePrice;

    
    
    void bookTicket(){
        Layout.print(Movies.nowShowing());
        Scanner input = new Scanner(System.in);
        System.out.print("Select the Movie: ");
        String choice;
        do{
            choice = input.nextLine();
        }while(!setMovieName(choice));
        Layout.print(Movies.timings(choice));
        System.out.print("Select the time: ");
        do{
            choice = input.nextLine();
        }while(!setMovieTime(choice));

        input.close();
    }

    void cancelTicket(){

    }

    public String getMovieName() {
        return movieName;
    }

    public boolean setMovieName(String movieName) {
        String movies[] = Movies.nowShowing();
        for(int i=0; i<movies.length; i++) {
            if(movieName.equals(movie[i])) {
                this.movieName = movieName;
                return true;
            }
            System.out.println("Movie Does Not Exist.");
            return false;
        }
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
}