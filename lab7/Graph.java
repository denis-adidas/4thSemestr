import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Graph {
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
}
