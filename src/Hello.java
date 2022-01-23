import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        InputStreamReader isr=new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        String encoding = System.getProperty("console.encoding");
//        System.setProperty("console.encoding", "utf-8");
        String encoding = System.getProperty("console.encoding", "utf-8");
        System.setProperty("console.encoding", String.valueOf(StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in, encoding);
        PrintStream ps = new PrintStream(System.out,true, encoding);
        ps.println("Привет");

    }
}
