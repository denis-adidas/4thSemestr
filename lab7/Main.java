import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Settings a = new Settings();
        try {
            a.loadFromTextFile(new File("H:\\IntelliJ_projects\\lab07\\src\\in.txt"));
            System.out.println(a.toString());
            a.saveInBinaryFile(new File("H:\\IntelliJ_projects\\lab07\\src\\out.bin"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}