import java.io.*;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Settings {
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
    public boolean equals(Settings a) {
        return this.Setting.equals(a.Setting);
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
    public void saveInTextFile(File out) {

    }
        public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory() && file.canRead();
    }
}
