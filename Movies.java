import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Movies{

    static String[] nowShowing() throws Exception {
        File f = new File("./NowShowing.txt");
        FileReader in = new FileReader(f);
        char c[] = new char[1000];
        in.read(c);
        String s[] = String.valueOf(c).split("[,]");
        in.close();
        return s;
    }

    static String[] comingSoon() throws Exception {
        File f = new File("./ComingSoon.txt");
        FileReader in = new FileReader(f);
        char c[] = new char[1000];
        in.read(c);
        String s[] = c.toString().trim().split("[,]");
        in.close();
        return s;
    }

    static String[] timings(String movie) throws Exception{
        // File f = new File("./Timing.txt");
        // FileReader in = new FileReader(f);
        // List<String> s = new ArrayList<String>();
        // List<Character> ch = new ArrayList<Character>();
        // char c = (char)in.read();
        // while(in.ready()) {
        //     while(c != ' ') {
        //         ch.add(c);
        //         c = (char)in.read();
        //     }
        //     ch.clear();
        //     if(String.valueOf(ch).equals(movie)) {
        //         while(c != ' ') {
        //             ch.add(c);
        //             c = (char)in.read();
        //         }
        //         s.add(String.valueOf(ch));
        //         ch.clear();
        //     }
        // }
        // in.close();
        // return (String[])s.toArray();
    }
}