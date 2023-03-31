import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.*;


public class EncodingConverter {

    public static void main(String[] args) {
        String[] arg = {"H:\\IntelliJ_projects\\lab06\\src\\in.txt", "H:\\IntelliJ_projects\\lab06\\src\\out.txt", "utf8", "ascii"};

        try {
            convert(arg[0], arg[1], arg[2], arg[3]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void convert(String inputFile, String outputFile, String firstEncoding, String secondEncoding) throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream(inputFile), firstEncoding);
        Writer writer = new OutputStreamWriter(new FileOutputStream(outputFile), secondEncoding);
        int c = 0;
        while ((c = reader.read()) >= 0) {
            writer.write(c);
        }
        System.out.print("Complete encoding!");
        reader.close();
        writer.close();
    }
};
