import java.io.File;

public class Movies{

    static String[] nowShowing() throws Exception {
        File f = new File("./NowShowing.txt");
        FileInput in = new FileInput(f);
        String[] s = in.readline().trim().split("[/]");
        in.close();
        return s;
    }

    static String[] comingSoon() throws Exception {
        File f = new File("./ComingSoon.txt");
        FileInput in = new FileInput(f);
        String s[] = in.readline().trim().split("[/]");
        in.close();
        return s;
    }

    static String[] timings(String movie) throws Exception{
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

    static String[] dates() throws Exception{
        File f = new File("./dates.txt");
        FileInput in = new FileInput(f);
        String[] s = in.readline().trim().split("[:]");
        in.close();
        return s;
    }
}