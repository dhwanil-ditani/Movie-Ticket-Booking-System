import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Movies{

    String movieName;
    String movieDescription;

    public Movies(String movieName, String movieDescription) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
    }

    static Movies[] nowShowing() throws IOException {
        File f = new File("./NowShowing.txt");
        FileInput in = new FileInput(f);
        String[] s = in.readFile().trim().split("\n");
        Movies[] movies = new Movies[s.length/2];
        for(int i=0; i<s.length/2; i++) {
            movies[i] = new Movies(s[2*i], s[2*i + 1]);
        }
        in.close();
        return movies;
    }

    static String[] comingSoon() throws IOException {
        File f = new File("./ComingSoon.txt");
        FileInput in = new FileInput(f);
        String[] s = in.readFile().split("\n");
        in.close();
        return s;
    }

    static String[] timings(String movie) throws IOException{
        File f = new File("./Timing.txt");
        FileInput in = new FileInput(f);
        String[] s;
        String str = "";
        String[] temp;
        while(in.ready()) {
            temp = in.readline().trim().split("/");
            if(temp[0].equalsIgnoreCase(movie)) {
                str = str.concat(temp[1] + " ");
            }
        }
        s = str.trim().split(" ");
        in.close();
        return s;
    }

    static String[] dates() throws IOException{
        String[] str = new String[7];
        String[] temp;
        Calendar cal = Calendar.getInstance();
        temp = cal.getTime().toString().split(" ");
        str[0] = temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[5];
        for(int i=1; i<7; i++) {
            cal.add(Calendar.DATE, 1);
            temp = cal.getTime().toString().split(" ");
            str[i] = temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[5];
        }
        return str;
    }
}