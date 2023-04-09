import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<List<Integer>> adjacencyList;
    int nodes;

    public Graph(int vertices) {
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<Integer>());
        }
        nodes = vertices;
    }
    @Override
    public String toString() {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < adjacencyList.size(); i++) {
            c.append(adjacencyList.get(i).toString());
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
            if (adjacencyList.get(node).get(edge) > 0)
                return;
            else
                adjacencyList.get(node).add(edge);
    }
    public void delete(int node, int edge) throws IllegalArgumentException{
        if ((node >= 0 && node < nodes) && (edge >= 0 && edge < nodes))
            if (adjacencyList.get(node).get(edge) > 0)
                adjacencyList.get(node).remove(edge);
            else
                throw new IllegalArgumentException("Error: this edge is doesn't exist \n");
    }
    public List<Integer> getAdjacencyList(int v) {
        return adjacencyList.get(v);
    }
    public boolean isConnect(int first_node, int second_node) {
        if ((first_node >= 0 && first_node < nodes) && (second_node >= 0 && second_node < nodes))
            
    }
}
