import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private int V; // number of vertices
    public Map<Integer, List<Integer>> adjList; //Adjacency list representation

    public Graph(int vertices){
        this.V = vertices; // set number of vertices
        adjList = new HashMap<>();
        for(int i = 0 ; i<V;i++){
            adjList.put(i,new LinkedList<>()); // we have hashmap and keys are integers
        }
    }
    // Add an edge to the graph
    public void addEdge(int src , int dest){
        adjList.get(src).add(dest);
    }
    // Print the graph
    public void printGraph(){
        for(Map.Entry<Integer,List<Integer>> entry : adjList.entrySet()){
            int vertex = entry.getKey();
            List<Integer> edges = entry.getValue();
            System.out.println("Vertex "+vertex+" is connected to: ");
            for(Integer edge : edges){
                System.out.println(edge + " ");
            }
            System.out.println();
        }
    }
}
