import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class t {
    public static void main(String[] args) throws IOException {
        File f = new File("./NowShowing.txt");
        FileInput in = new FileInput(f);
        String[] s = in.readFile().split("\n");
        for(int i=0,j=0; i<s.length/2 && j<s.length; i++, j=j+2) {
            System.out.println(s[j]);
            System.out.println(s[j + 1]);
        }
        in.close();
    }
}