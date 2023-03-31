import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FormattedInput {

    private static final String[] VALID_FORMATS = {"%d", "%f", "%s", "%c"};
    public static void main(String[] args) {
        Object[] test = scanf("%d %s %c");
        for (Object obj : test) {
            System.out.println(obj.getClass().getName() + ": " + obj);
        }
    }

    public static Object[] scanf(String format) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                Object[] result = sscanf(format, sc.nextLine());
                sc.close();
                return result;
            }
            catch (IllegalArgumentException a) {
                System.out.println("Error: invalid input. Please try again.");
            }
        }
    }

    public static Object[] sscanf(String  format, String input) {
        String[] inputData = input.split(" ");
        HashSet<String>  validFormats = new HashSet<>(Arrays.asList(VALID_FORMATS));
        HashSet<String> inputFormat = new HashSet<>(Arrays.asList(format.split(" ")));

        boolean formatIsValid = true;
        for (String f : inputFormat) {
            formatIsValid = validFormats.contains(f);
            if (!formatIsValid)
                break;
        }
        if (!formatIsValid || inputData.length != inputFormat.size()) {
            throw new IllegalArgumentException("Error: not valid format.");
        }

        Object[] result = new Object[inputData.length];
        int i = 0;
        for (String f : inputFormat) {
            switch (f) {
                case "%d" -> result[i] = Integer.parseInt(inputData[i]);
                case "%f" -> result[i] = Double.parseDouble(inputData[i]);
                case "%s" -> result[i] = inputData[i];
                case "%c" -> {
                    if (inputData[i].length() != 1) {
                        throw new IllegalArgumentException("Error: input data does not match format.");
                    } else {
                        result[i] = inputData[i].charAt(0);
                    }
                }
                default -> {
                }
            }
            i++;
        }
        return result;
    }

}