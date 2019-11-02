import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput extends FileReader {

    public FileInput(File file) throws FileNotFoundException {
        super(file);
    }

    public String readline() throws IOException {
        String str = "";
        char c;

        c = (char)read();
        while(c != '\n') {
            str = str.concat(String.valueOf(c));
            if(!ready()) {break;}
            c = (char)read();
        }
        return str;
    }

}