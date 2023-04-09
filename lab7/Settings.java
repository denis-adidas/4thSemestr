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
    public void loadFromTextFile(String filename) throws IOException, UnsupportedEncodingException {
        try (FileReader fileReader = new FileReader(filename)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] settings;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                settings = line.split(" = ");
                if (settings.length != 2) {
                    throw new IllegalArgumentException("Invalid input format");
                }
                Setting.put(settings[0].trim(), parseInt(settings[1].trim()));
            }
        } catch (IOException e) {
            throw new IOException("Error: " + e.getMessage());
        }
    }
    public void loadFromBinaryFile(String file) throws IOException {
        try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
            while (input.available() > 0) {
                String key = input.readUTF();
                int value = input.readInt();
                Setting.put(key, value);
            }
        }
        catch (IOException e) {
            throw new IOException("Error: " + e.getMessage());
        }
    }
    public void saveInTextFile(String filename) throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(filename))) {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
            writer.println(this.toString());
            writer.close();
        }
        catch (IOException e){
            throw new IOException("Error: " + e.getMessage());
        }
    }
    public void saveInBinaryFile(String filename) throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(filename))) {
            for (Map.Entry<String, Integer> entry : Setting.entrySet()) {
                output.writeUTF(entry.getKey());
                output.writeInt(entry.getValue());
            }
        }
        catch (IOException e) {
            throw new IOException("Error: " + e.getMessage());
        }
    }
}
