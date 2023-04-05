import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Settings implements Serializable {
    private HashMap<String, Integer> Setting;
    int count;
    boolean Default;

    public Settings() {
        Setting = new HashMap<>();
        count = 0;
        Default = true;
    }

    @Override
    public String toString() {
        StringBuilder c = new StringBuilder();
        c.append("Settings: \n").append(Setting.toString());
        c.append("\n Default: " + Default);
        return c.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Settings)) {
            return false;
        }

        Settings settings = (Settings) obj;
        return settings.Setting.equals(this.Setting);
    }

    public void put(String setting, int mode) {
        Setting.put(setting, mode);
    }
    public void delete(String setting) throws IllegalArgumentException{
        if (Setting.containsKey(setting))
            Setting.remove(setting);
        else
            throw new IllegalArgumentException("Error: no such setting in config \n");
    }
    public int get(String setting) throws IllegalArgumentException{
        if (Setting.containsKey(setting))
            return Setting.get(setting);
        else
            throw new IllegalArgumentException("Error: no such setting in config \n");
    }
    public void loadFromTextFile(File in) throws FileNotFoundException {
          try (FileReader fileReader = new FileReader(in)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] settings;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                settings = line.split(" ");
                Setting.put(settings[0], parseInt(settings[1]));
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Error: file not found or can't be reading.");
        }
    }
    public void loadFromBinaryFile(File filename) throws IOException {
        try (DataInputStream input = new DataInputStream(new FileInputStream(filename))) {
            try {
                String key = input.readUTF();
                int value = input.readInt();
                Setting.put(key, value);
            } catch (EOFException e) {
                return;
              }
        }
    }
//public void loadFromBinaryFile(String filename) throws FileNotFoundException, RuntimeException {
//        try {
////            String src = "C:\\Users\\zxggx\\IdeaProjects\\laba7\\src\\";
//            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
//            String a = in.readLine();
//            String[] c = a.split(" ");
//            for (int i = 0;i<c.length;i++) {
//                String[] b = c[i].split(":");
//                this.put(b[0], Integer.parseInt(b[1]));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public void saveInTextFile(File out) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(out);
        writer.println(this.toString());
        writer.close();
    }
    public void saveInBinaryFile(File out) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(out))) {
            objectOutputStream.writeObject(this);
        }
    }
}
