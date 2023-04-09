import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Settings a = new Settings();

//        a.loadFromTextFile("H:\\IntelliJ_projects\\lab07\\src\\in.txt");
        System.out.println(a.toString());
//        a.saveInTextFile("H:\\IntelliJ_projects\\lab07\\src\\out.txt");
    }
}