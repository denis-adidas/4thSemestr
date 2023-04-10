import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Graph a = new Graph(4);
//        a.loadFromTextFile("H:\\IntelliJ_projects\\lab07\\src\\in_g.txt");
        a.loadFromBinaryFile("H:\\IntelliJ_projects\\lab07\\src\\out_g.bin");
//        System.out.println(a.toString());
//        a.saveInBinaryFile("H:\\IntelliJ_projects\\lab07\\src\\out_g.bin");
    }
}