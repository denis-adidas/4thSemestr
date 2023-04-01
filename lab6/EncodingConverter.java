import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.*;


public class EncodingConverter {

    public static void main(String[] args) {
//        String[] arg = {"H:\\IntelliJ_projects\\lab06my\\src\\in.txt", "H:\\IntelliJ_projects\\lab06my\\src\\out.txt", "ascii"};

//        String help = "--help";

        if (args.length < 3) {
            System.out.println("Error: insufficient arguments. Usage: java EncodingConverter <input file> <output file> <encoding>");
            return;
        }

        if (args[0].equals("--help")) {
            System.out.println(help());
            return;
        }

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        while (true) {
            try {
                convert(inputFile, outputFile, args[2]);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage() + ". Please try again.");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter input file name: ");
                String input = scanner.nextLine();
                inputFile = new File(input);
                System.out.print("Enter output file name: ");
                String output = scanner.nextLine();
                outputFile = new File(output);
            } catch (UnsupportedCharsetException e) {
                System.out.println("Error: " + e.getMessage() + ". Please try again.");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter encoding: ");
                String encoding = scanner.nextLine();
                args[2] = encoding;
            } catch (Exception e) {
                System.out.println("Error: invalid input. Please try again.");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter input file name: ");
                String input = scanner.nextLine();
                inputFile = new File(input);
                System.out.print("Enter output file name: ");
                String output = scanner.nextLine();
                outputFile = new File(output);
                System.out.print("Enter encoding: ");
                String encoding = scanner.nextLine();
                args[2] = encoding;
            }
        }

    }

    public static void convert(File inputFile, File outputFile, String secondEncoding) throws IOException {
        if (!isFileExists(inputFile))
            throw new FileNotFoundException("Error: input file does not exist");
        if (!isFileExists(outputFile))
            throw new FileNotFoundException("Error: output file does not exist");

        SortedMap<String,Charset> charsets = Charset.availableCharsets();
        if (!charsets.containsKey(secondEncoding))
            throw new InvalidPropertiesFormatException("Error: encoding does not exist.");

        String firstEncoding = String.valueOf(Charset.defaultCharset());
//        System.out.println(firstEncoding);

        Reader reader = new InputStreamReader(new FileInputStream(inputFile), firstEncoding);
        Writer writer = new OutputStreamWriter(new FileOutputStream(outputFile), secondEncoding);
        int c = 0;
        while ((c = reader.read()) >= 0) {
            writer.write(c);
        }
        System.out.print("Complete encoding!🍺");
        reader.close();
        writer.close();

    }

    public static String help() {
        String help = "🍺EncodingConverter convert first file with his encode to second file with required encode \n" +
                "Encoding converter take 3 arguments: \n" +
                "1. Input file;\n" +
                "2. Output file;\n" +
                "3. Required encode.\n";
        return help;
    }

    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }
};
