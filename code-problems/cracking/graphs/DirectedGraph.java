import java.util.*;

public class DirectedGraph {

    class Vertex {
        public String id;
        public boolean visited;

        // List of adjacent vertices
        public ArrayList<Vertex> adjacencyList;

        /* Construct a new Vertex with a unique name. */
        public Vertex(String uniqueName) {
            this.id = uniqueName;
            adjacencyList = new ArrayList<Vertex>();
        }

        /* Add a directed edge from this vertex to v. */
        private void addEdge(Vertex v) {
            adjacencyList.add(v);
        }
    }

    // Represents the Graph's vertices
    private ArrayList<Vertex> vertices;

    /* Construct a new Directed Graph. */
    public DirectedGraph() {
        vertices = new ArrayList<Vertex>();
    }

    /* Add a vertex to the Graph with given id. */
    public void addVertex(String id) {
        vertices.add(new Vertex(id));
    }

    public void addVertices(String[] names) {
        for (int i = 0; i < names.length; i++) {
            addVertex(names[i]); 
        }
    }

    /* * *  
     * Add a directed edge between Vertex with id "a" and Vertex with
     * id "b"; nothing happens if one of these vertices do not exist. 
     * * */
    public void addEdge(String a, String b) {
        Vertex aVertex = getVertex(a);
        Vertex bVertex = getVertex(b);
        if (aVertex != null && bVertex != null && 
                (!edgeExists(aVertex, bVertex))) { 
            aVertex.addEdge(bVertex);
        }
    }
    
    /* Determine if edge exists from Vertex a to Vertex b. */ 
    private boolean edgeExists(Vertex a, Vertex b) {
        for (Vertex v : a.adjacencyList) {
            if (v.id.equals(b.id)) {
                return true; 
            }
        }
        return false;
    }

    /* Get vertex with given id. */
    private Vertex getVertex(String id) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).id.equals(id)) 
                return vertices.get(i);
        }
        return null;
    }

    /* A procedure that "unvisits" all the vertices. */
    private void unvisitVertices() {
        for (Vertex v : vertices) {
            v.visited = false;
        }
    }

    /* * * * * * * * * * * * * * * * * * * * 
     * Print a depth first traversal starting from 
     * Vertex with given id. 
     * * * */
    public void depthFirstPrint(String id) {
        Vertex v = getVertex(id);

        // before we traverse, mark all vertices as unvisited
        unvisitVertices();

        if (v != null) {
            depthFirstPrint(v);
            System.out.print("\n");
        }
    }

    private void depthFirstPrint(Vertex root) {
        if (root == null) return; // base case
        else {
           // visit the vertex
           System.out.print(root.id + " ");
           root.visited = true;

           // visit unvisited adjacent vertices
           for (Vertex v : root.adjacencyList) {
               if (!v.visited) 
                    depthFirstPrint(v); 
           }
        }
    }

    /* * * * 
     * Print a breadth first traversal startig from 
     * Vertex with given id.
     * */
    public void breadthFirstPrint(String id) {
        Vertex v = getVertex(id);
        if (v != null) {
            unvisitVertices();
            
            Queue<Vertex> queue = new LinkedList<Vertex>();
            System.out.print(v.id + " ");
            v.visited = true;
            queue.add(v);

            while (!queue.isEmpty()) {
                Vertex dequeuedVertex = queue.remove();

                for (Vertex x : dequeuedVertex.adjacencyList) {
                    if (!x.visited) {
                        System.out.print(x.id + " ");
                        x.visited = true;
                        queue.add(x);
                    }
                }
            }

            System.out.print("\n");
        }
    }

    /* * * *  
     * Determine if a route exists from a Vertex with
     * id "a" and id "b".
     *
     * A route exists from Vertex a to Vertex b if we
     * perform a depth first traversal from a, and
     * b is marked as "visited."
     * * * */
    public boolean routeExists(String a, String b) {
       Vertex vertexA = getVertex(a);
       Vertex vertexB = getVertex(b);
       if (vertexA != null && vertexB != null) {
           unvisitVertices();
           depthFirstTraversal(vertexA);
           if (vertexB.visited) return true;
           else return false;
       }
       return false;
    }

    /* * * *
     * Traverse the Graph starting at given Vertex.
     * */
    private void depthFirstTraversal(Vertex root) {
        if (root == null) return;
        else {
            root.visited = true;
            for (Vertex v : root.adjacencyList) {
                if (!v.visited) 
                    depthFirstTraversal(v); 
            }
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G"};
        graph.addVertices(vertices);

        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("E", "F");
        graph.addEdge("D", "F");
        graph.addEdge("D", "G");
        graph.addEdge("D", "C");
        graph.addEdge("G", "A");
        graph.addEdge("C", "G");

        // graph.depthFirstPrint("D");
        // graph.breadthFirstPrint("D");
        System.out.println(graph.routeExists("B", "A"));
        System.out.println(graph.routeExists("D", "E"));
    }

}
