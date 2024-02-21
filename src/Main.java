
import java.util.*;

class Vertices {
    public int y;
    public int x;
    public int name;
    public Vertices(int y , int x, int name){
        this.y = y;
        this.x = x;
        this.name = name;
    }
}
public class Main {

    static int Ve = 225; //number of vertices in the graph
    static Graph graph = new Graph(Ve);
    static ArrayList <Vertices> verticesList = new ArrayList<>();

    public static void DFS(Graph graph, int start, int finish, int[][] solution) {
        //System.out.println("Coordinates are (y,x) format");
        boolean[] visited = new boolean[solution.length * solution[0].length];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            solution[verticesList.get(currentVertex).y][verticesList.get(currentVertex).x] = 1; // Mark as part of the path

            if (currentVertex == finish) {
                //System.out.println(verticesList.get(currentVertex).name+ " Path Found!");
                break; // Reached the finish point
            }else //System.out.println("Vertices Number = "+verticesList.get(currentVertex).name+" Vertices Coords (" +verticesList.get(currentVertex).y+","+verticesList.get(currentVertex).x+")");

            for (int neighbor : graph.adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    public static void BFS(Graph graph, int start, int finish, int[][] solution) {
        //System.out.println("Coordinates are (y,x) format");
        boolean[] visited = new boolean[solution.length * solution[0].length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            solution[verticesList.get(currentVertex).y][verticesList.get(currentVertex).x] = 1; // Mark as part of the path

            if (currentVertex == finish) {
                //System.out.println(verticesList.get(currentVertex).name+" Path Found!");
                break; // Reached the finish point
            }else //System.out.println("Vertices Number = "+verticesList.get(currentVertex).name+" Vertices Coords (" +verticesList.get(currentVertex).y+","+verticesList.get(currentVertex).x+")");
            for (int neighbor : graph.adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] H = {
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,1,1,0,0,1,0,0,1},
                {0,0,0,1,1,0,1,0,0,1,1,0,1,1,0},
                {0,0,1,1,1,1,1,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,1,1,0,1,0,0,1,1,0},
                {0,1,1,0,1,0,0,0,1,1,1,1,1,1,0},
                {0,0,1,1,0,1,0,1,1,1,1,1,1,0,0},
                {0,1,1,0,1,0,1,1,0,1,0,0,0,0,0},
                {1,1,1,0,0,1,1,0,0,0,1,1,0,1,0},
                {0,0,0,1,1,0,0,1,1,0,0,0,1,0,0},
                {0,0,0,0,1,1,1,1,0,0,1,1,0,0,0},
                {0,0,1,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,1,1,0,1,1,0,0,0,0,0,1,0,1,1},
                {0,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,1,0,1,1,0,1,1,0,0,1,1,1,1,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };

        int[][] V = {
                {1,0,0,0,0,1,1,0,0,0,1,0,0,1,0,1},
                {1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1},
                {1,1,1,0,0,0,0,1,1,0,1,1,1,0,1,1},
                {1,1,1,0,0,1,0,0,0,1,1,0,0,1,0,1},
                {1,1,0,1,0,1,1,0,1,0,0,1,0,0,1,1},
                {1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,1},
                {1,1,0,1,0,1,0,1,0,0,1,0,1,1,1,1},
                {1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1},
                {1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1},
                {1,1,1,1,0,0,1,0,0,1,1,0,1,0,1,1},
                {1,1,0,1,1,1,0,0,0,1,1,0,1,1,1,1},
                {1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,1},
                {1,1,0,0,1,0,1,1,1,1,1,0,1,1,0,1},
                {1,1,0,1,0,1,1,0,1,1,0,0,1,0,1,1},
                {1,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1},
        };
        int [][] solution= {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
        int count = 0 ;

        //Turn Maze into a graph
        for(int e = 0 ; e < solution.length ; e++) {
            for(int r = 0; r< solution[0].length; r++){
               Vertices vertices = new Vertices(e, r, count);
               verticesList.add(vertices);
               count++;
            }
        }
        for (Vertices element : verticesList){
            if(H[element.y][element.x] == 0){
                graph.addEdge(element.name,element.name-H[0].length);
            }
            if(H[element.y+1][element.x] == 0){
                graph.addEdge(element.name,element.name + H[0].length);
            }
            if(V[element.y][element.x] == 0){
                graph.addEdge(element.name, element.name - 1);
            }
            if(V[element.y][element.x+1] == 0){
                graph.addEdge(element.name,element.name+1);
            }
        }

        //graph.printGraph(); //show connection between vertices

        System.out.println("----Breadth First Search Path----");
        BFS(graph, 7, 217, solution);
        System.out.println();
        printMap(solution);//Print Solution Path

        // Set each element of the array to zero
        resetArrayToZero(solution);

        System.out.println("----Depth First Search Path----");
        DFS(graph, 7, 217, solution);
        System.out.println();
        printMap(solution);

        drawMaze(H,V); //Drawing 2d Maze
    }
    public static void printMap(int [][] solution){
        for (int[] row : solution) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void drawMaze(int[][] H, int[][] V) {
        int i = 0;
        int j = 0 ;
        while (i!=16){

            if(i <= 14 && j <= 15){
                if (V[i][j] == 1) {
                    System.out.print("|");
                }else System.out.print(" ");
            }

            if( i <= 15 && j <= 14){
                if( i == 15 ){
                    if (H[i][j] == 1) {
                        System.out.print('\u0305');
                    }
                }
                if (H[i][j] == 1) {
                    System.out.print('\u0305');
                }else System.out.print(" ");
            }


            j++;
            if(j == 16){
                System.out.println();
                i++;
                j=0;
            }
        }

    }
    // Function to reset a 2D array to zero
    public static void resetArrayToZero(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 0;
            }
        }
    }

}

