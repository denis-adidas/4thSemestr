import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Graph {
    private static final String[] AccessText = {"Text", "text", "TEXT", "txt", "TXT", ".txt"};
    private static final String[] AccessBin = {"Binary", "binary", "BINARY", "bin", "BIN", ".bin"};

    public void GraphStore(String InputFileName, String InputFileType) throws IOException {
        if (InputFileName == null || InputFileType == null)
            throw new IOException("Error: input file name or type are null \n");
        for (String it : AccessText) {
            if (InputFileType == it) {
                this.loadFromTextFile(InputFileName);
                return;
            }
        }
        for (String it : AccessBin) {
            if (InputFileType == it) {
                this.loadFromBinaryFile(InputFileName);
                return;
            }
        }
    }
    public void GraphStore(String InputFileName, String InputFileType, String OutputFileName, String OutputFileType) throws IOException {
        GraphStore(InputFileName, InputFileType);
        if (OutputFileName == null || OutputFileType == null)
            throw new IOException("Error: output file name or type are null \n");
        for (String it : AccessText) {
            if (OutputFileType == it) {
                this.saveInTextFile(OutputFileName);
                return;
            }
        }
        for (String it : AccessBin) {
            if (OutputFileType == it) {
                this.saveInBinaryFile(OutputFileName);
                return;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3 || args[0].equals("--help")) {
            System.out.println("Error: insufficient arguments. Usage: java Graph.java <count of nodes> <input file name> <type of input file> <output file name> <type of output file>");
            System.out.println(help());
            return;
        }

        int nodes = parseInt(args[0]);
        String InputFileName = args[1];
        String InputFileType = args[2];

//        String OutputFileName = null;
//        String OutputFileType = null;
//        if (args.length > 3) {
//            OutputFileName = args[3];
//            OutputFileType = args[4];
//        }

        Graph a = new Graph(nodes);

        a.GraphStore(InputFileName, InputFileType);
        System.out.println("🍺Complete!");
    }
    private List<List<Integer>> adjacencyList;
    int nodes;

    public Graph(int vertices) {
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        nodes = vertices;
    }
    @Override
    public String toString() {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < adjacencyList.size(); i++) {
            c.append(adjacencyList.get(i).toString()).append("\n");
        }
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
        Graph obj_nodes = (Graph)obj;
        return obj_nodes.adjacencyList.equals(this.adjacencyList);
    }

    public void append(int node, int edge) {
        if ((node >= 0 && node < nodes) && (edge >= 0 && edge < nodes))
            if (adjacencyList.get(node).contains(edge))
                return;
            else
                adjacencyList.get(node).add(edge);
    }
    public void delete(int node, int edge) throws IllegalArgumentException{
        if ((node >= 0 && node < nodes) && (edge >= 0 && edge < nodes))
            if (adjacencyList.get(node).contains(edge))
                adjacencyList.get(node).remove(edge);
            else
                throw new IllegalArgumentException("Error: this edge is doesn't exist \n");
    }
    public List<Integer> getAdjacencyList(int v) {
        return adjacencyList.get(v);
    }
    public boolean isConnect(int first_node, int second_node) {
        if ((first_node >= 0 && first_node < nodes) && (second_node >= 0 && second_node < nodes))
            return adjacencyList.get(first_node).get(second_node) > 0;
        return false;
    }
    public void loadFromTextFile(String filename) throws IOException, UnsupportedEncodingException {
        try (FileReader fileReader = new FileReader(filename)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] input_nodes;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                input_nodes = line.split(" ");
                if (input_nodes.length != 2) {
                    throw new IllegalArgumentException("Invalid input format");
                }
                this.append(parseInt(input_nodes[0].trim()) - 1, parseInt(input_nodes[1].trim()) - 1);
            }
        } catch (IOException e) {
            throw new IOException("Error: " + e.getMessage());
        }
    }
    public void loadFromBinaryFile(String file) throws IOException {
        try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
            while (input.available() > 0) {
                int node = input.readInt();
                int edge = input.readInt();
                this.append(node, edge);
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
            for (List<Integer> list : adjacencyList) {
                output.writeInt(adjacencyList.indexOf(list));
                for (Integer value : list) {
                    output.writeInt(value);
                }
            }
        }
        catch (IOException e) {
            throw new IOException("Error: " + e.getMessage());
        }
    }
    private static String help() {
        StringBuilder c = new StringBuilder();
        c.append("Hello, it's GraphDock. If you need to store your graph from Text or Binary file, then write \n" +
                "it like this \"java Graph.java <count of nodes> <input file name> <output file name> <type of input file> <type of output file>\" \n");
        return c.toString();
    }
}
