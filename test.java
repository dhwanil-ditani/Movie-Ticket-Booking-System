import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        File f = new File("./seats.txt");
        FileReader reader = new FileReader(f);
        char c, i = 'A';
        int j = 0;
        
        while(reader.ready()) {
            c = (char)reader.read();
            if(checkAlphabet(c)) {
                i = c;
                j = 0;
            }
            if(c == '□') {
                j++;
                //if(checkAvailability(i, j)) {

                //}
                //else {
                    System.out.print("*");
                //}
            }
            else {
                System.out.print(c);
            }
        }
        reader.close();
    }

    static boolean checkAlphabet(char c) {
        if((c > 'a' && c < 'z') || (c > 'A' && c < 'Z')) {
            return true;
        }
        else {
            return false;
        }
    }

    static boolean checkAvailability(char row, int no) {
        return true;
    }
}