import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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

    public boolean setMovieName(String movieName) throws IOException {
        Movies movies[] = Movies.nowShowing();
        for (int i = 0; i < movies.length; i++) {
            if (movieName.equals(movies[i].movieName)) {
                this.movieName = movies[i].movieName;
                return true;
            }
        }
        System.out.println();
        System.out.println("Invalid Movie Name! Please try again.");
        System.out.println();
        return false;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public boolean setMovieTime(String movieTime) throws IOException {
        String[] timings;
        timings = Movies.timings(getMovieName());
        for (int i = 0; i < timings.length; i++) {
            if (movieTime.equalsIgnoreCase(timings[i])) {
                this.movieTime = movieTime;
                return true;
            }
        }
        System.out.println();
        System.out.println("Invalid Time! Please try again.");
        System.out.println();
        return false;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public boolean setMovieDate(String date) throws IOException {
        if(Integer.parseInt(date.split(" ")[2]) >= Integer.parseInt(Calendar.getInstance().getTime().toString().split(" ")[2]) || Integer.parseInt(date.split(" ")[2]) <= Integer.parseInt(Calendar.getInstance().getTime().toString().split(" ")[2] + 6)) {
            this.movieDate = date;
            return true;
        }
        System.out.println();
        System.out.println("Invalid Date! Please try again.");
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

    void bookTicket() throws IOException {
        Layout.clearScreen();

        Layout.displayEstelle();
        System.out.println("Now Showing.");
        System.out.println("__________________");
        System.out.println();
        
        Movies[] movies = Movies.nowShowing();
        Layout.print(movies);

        String choice;
        int ch1;
        int ch2;

        do {
            System.out.println("Choose a movie: ");
            ch2 = Integer.parseInt(input.nextLine());
        } while (!setMovieName(movies[ch2-1].movieName));

        Layout.clearScreen();

        Layout.displayEstelle();
        System.out.println("Showtimes for " + getMovieName() + ".");
        System.out.println("_____________________________________");
        System.out.println();

        String[] dates = Movies.dates();
        Layout.print(dates);

        do {
            System.out.println("Choose your preferred date for " + getMovieName()
                    + " (enter number corresponding to preferred date): ");
            ch1 = Integer.parseInt(input.nextLine());
        } while (!setMovieDate(dates[ch1 - 1]));

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
            if (choice.equals("1")) {
                if (!user.login()) {
                    user = null;
                }
            } else if (choice.equals("2")) {
                user.signUp();
            } else {
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
            cc.pay(200);
        }
        else {
            DebitCard dc = new DebitCard();
            dc.pay(200);
        }

        try {
            System.out.println("Booking confirmed :) Thank you for choosing Estelle!");
            System.out.println();
            Layout.print(user);
            System.out.println();
            System.out.println("Movie: " + getMovieName());
            System.out.println("Showtime: " + getMovieTime());
            System.out.println();

            File f = new File("tickets.txt");
            FileInput reader = new FileInput(f);
            String data = reader.readFile();
            reader.close();
            System.out.println(data);
            FileWriter writer = new FileWriter(f);
            writer.write(data + "\n");
            writer.write(getMovieName()+";"+getMovieTime()+";"+getMovieDate()+";"+getSeatNumber()+";"+getMoviePrice()+";"+user.getUsername()+";");
            writer.close();
            System.out.println("Press Enter to go back to the main menu. ");
            input.nextLine();
            input.nextLine();
        }
        catch(NullPointerException e) {
            System.out.println("Booking failed! :(");
            System.out.println();
            System.out.println("Press Enter to go back to the main menu. ");
            input.nextLine();
            input.nextLine();
        }
    }

    static Ticket[] getTickets(String username, String password) throws IOException {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        File f = new File("./tickets.txt");
        String[] data;
        String[] temp;
        FileInput reader = new FileInput(f);
        while(reader.ready()) {
            Ticket t = new Ticket();
            data = reader.readline().split("[;]");
            for(int i=0; i<data.length; i++) {
                temp = data[i].split("[:]");
                switch(temp[0]) {
                    case "Movie":
                        t.setMovieName(temp[1]);
                        break;
                    case "Time":
                        t.setMovieTime(temp[1]);
                        break;
                    case "Date":
                        t.setMovieDate(temp[1]);
                        break;
                    case "SeatNo":
                        t.setSeatNumber(temp[1]);
                        break;
                    case "Price":
                        t.setMoviePrice(Double.parseDouble(temp[1]));
                        break;
                    case "Username":
                        if(username.equals(temp[1])) {
                            t.user.auth(username, password);
                            tickets.add(t);
                        }
                        break;
                }
            }
        }
        reader.close();
        return (Ticket[])tickets.toArray();
    }

    void cancelTicket() throws IOException {
        int choice;
        Ticket[] tickets;
        String[] data;
        String[] t;
        String temp = "";

        File f = new File("./tickets.txt");
        FileInput reader = new FileInput(f);

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
            choice = Integer.parseInt(input.nextLine());
            if(choice == 1) {
                if(!user.login()) {
                    user = null;
                }
            }
            else if(choice == 2) {
                user.signUp();
            }
            else {
                System.out.println("Invalid input, please try again!");
            }
        }
        data = reader.readFile().split("\n");
        for(int i=0; i<data.length; i++) {
            if(data[i].split(";")[5].equals(user.getUsername())) {
                temp = temp.concat(data[i] + "\n");
            }
        }
        System.out.println(temp);
        reader.close();
        t = temp.split("\n");
        System.out.print(t.length);
        tickets = new Ticket[t.length];
        for(int i=0; i<t.length; i++) {
            tickets[i] = new Ticket();
            tickets[i].setMovieName(t[i].split(";")[0]);
            tickets[i].setMovieTime(t[i].split(";")[1]);
            tickets[i].setMovieDate(t[i].split(";")[2]);
            tickets[i].setSeatNumber(t[i].split(";")[3]);
            tickets[i].setMoviePrice(Double.parseDouble(t[i].split(";")[4]));
            tickets[i].user = user;
        }
        Layout.clearScreen();
        Layout.displayEstelle();
        Layout.print(tickets);
        System.out.println();
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine());
                setMovieName(tickets[choice - 1].getMovieName());
                setMovieTime(tickets[choice - 1].getMovieTime());
                setMovieDate(tickets[choice - 1].getMovieDate());
                setMoviePrice(tickets[choice - 1].getMoviePrice());
                setSeatNumber(tickets[choice - 1].getSeatNumber());
            }
            catch(NumberFormatException e) {
                choice = 0;
            }
            System.out.print("\r");
        }while(choice <= 0 || choice > tickets.length);
        System.out.println();

        Layout.clearScreen();
        Layout.displayEstelle();
        Layout.print(tickets[choice-1]);
        System.out.println("Cancellation successful!");
        FileWriter writer = new FileWriter(f);
        for(int i=0; i<data.length; i++) {
            if(data[i].equals(getMovieName()+";"+getMovieTime()+";"+getMovieDate()+";"+getSeatNumber()+";"+getMoviePrice()+";"+user.getUsername()+";")) {
                continue;
            }
            else {
                writer.write(data[i] + "\n");
            }
        }
        writer.close();
        input.nextLine();
    }
}
//Joker;11:45PM;Sun Nov 10 2019;A4;200.0;dhwanil-ditani;