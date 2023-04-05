import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Settings a = new Settings();
        try {
            a.loadFromBinaryFile(new File("/Users/denis_adidas/IdeaProjects/lab07/src/out2.bin"));
            System.out.println(a.toString());
            a.saveInTextFile(new File("/Users/denis_adidas/IdeaProjects/lab07/src/out.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}