import java.io.File;

public class Movies{

    static String[] nowShowing() throws Exception {
        File f = new File("./NowShowing.txt");
        FileInput in = new FileInput(f);
        String[] s = in.readline().trim().split("[,]");
        in.close();
        return s;
    }

    static String[] comingSoon() throws Exception {
        File f = new File("./ComingSoon.txt");
        FileInput in = new FileInput(f);
        String s[] = in.readline().trim().split("[,]");
        in.close();
        return s;
    }

    static void timings(String movie) throws Exception{
        
    }
}