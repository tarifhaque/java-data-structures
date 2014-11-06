public class Graph {

	/* Represents a single vertex in the graph. */
	class Vertex {
		LinkedList<Neighbor> inList; // neighbors that point to this vertex.
		LinkedList<Neighbor> outList; // neighbors this vertex points to.
		char label; // each vertex has a character label.
		boolean visited;

		public Vertex(char name) {
			label = name;
			inList = new LinkedList<>();
			outList = new LinkedList<>();
		}

		public void printVertex() {
			System.out.print(label + " ");
		}
	}

	/*
	 * Neighbors populate the adjacency list associated with each vertex in the
	 * graph.
	 */
	class Neighbor {
		Vertex vertex; // the neighbor vertex.
		int edge; // the edge (weight) to neighbor vertex.

		public Neighbor(Vertex v, int edgeWeight) {
			vertex = v;
			edge = edgeWeight;
		}

		public void printNeighbor() {
			System.out.println("[" + vertex.label + ", " + edge + "]");
		}
	}

	Vertex currentVertex; // reference to the current vertex of the graph.
	LinkedList<Vertex> vertices; // list of all vertices associated with graph.
	int edges;
	private boolean seen[];

	/******************************************************
	 * Initially the graph should have 26 vertices labeled 'A', 'B', 'C', ...,
	 * 'Z' and no edges, and the current vertex should be 'A'
	 ******************************************************/
	Graph() {
		vertices = new LinkedList<Vertex>();
		edges = 0;

		for (int i = 0; i < 26; i++) {
			// ASCII value of 'A' is 65
			Vertex vertex = new Vertex((char) (i + 65));
			vertices.add(vertex);
		}
		currentVertex = vertices.get(0);
		seen = new boolean[26];
	}

	/* Return the number of edges in the graph. */
	public int numEdges() {
		return edges;
	}

	/* Given the label, return the vertex. */
	Vertex findVertex(char v) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).label == v)
				return vertices.get(i);
		}
		return null; // return null if not found.
	}

	/* Given a label & in/out list, return the Neighbor. */
	Neighbor findNeighbor(LinkedList<Neighbor> list, char v) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).vertex.label == v)
				return list.get(i);
		}
		return null;
	}

	/* Set the current vertex to the vertex with label v. */
	public void gotoVertex(char v) {
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).label == v) {
				currentVertex = vertices.get(i);
				return;
			}
		}
		System.out.println("The vertex " + v + " does not exist.");
	}

	/* Return the in-degree of the current vertex. */
	public int inDegree() {
		return currentVertex.inList.size();
	}

	/* Return the out-degree of the current vertex. */
	public int outDegree() {
		return currentVertex.outList.size();
	}

	/* [TEST] Print labels of all the vertices in graph. */
	public void printVertices() {
		for (int i = 0; i < vertices.size(); i++)
			System.out.print(vertices.get(i).label);
	}

	/* Print the labels of all incoming edges to current vertex. */
	public void inIncidentEdges() {
		for (int i = 0; i < currentVertex.inList.size(); i++) {
			System.out.print(currentVertex.inList.get(i).edge + " ");
		}
		printLine();
	}

	private void printLine() {
		System.out.println();
	}

	/* Print the labels of all outgoing edges from current vertex. */
	public void outIncidentEdges() {
		for (int i = 0; i < currentVertex.outList.size(); i++) {
			System.out.print(currentVertex.outList.get(i).edge + " ");
		}
		printLine();
	}

	/*
	 * Print the labels of all vertices at other endpoint of incoming edges to
	 * current vertex.
	 */
	public void inAdjacentVertices() {
		for (int i = 0; i < currentVertex.inList.size(); i++) {
			System.out.print(currentVertex.inList.get(i).vertex.label + " ");
		}
		printLine();
	}

	/*
	 * Print the labels of all vertices at other endpoint of outgoing edges from
	 * current vertex.
	 */
	public void outAdjacentVertices() {
		for (int i = 0; i < currentVertex.outList.size(); i++) {
			System.out.print(currentVertex.outList.get(i).vertex.label + " ");
		}
		printLine();
	}

	/*
	 * Set current vertex to other endpoint of edge with label e outgoing from
	 * current vertex, if such edge exists.
	 */
	public void followEdge(int e) {
		for (int i = 0; i < currentVertex.outList.size(); i++) {
			Neighbor neighbor = currentVertex.outList.get(i);
			if (neighbor.edge == e) {
				currentVertex = neighbor.vertex;
				return;
			}
		}
		System.out.println("Edge to " + e + " not exist.");
	}

	/*
	 * Set current vertex to other endpoint of edge with label e incoming to
	 * current vertex, if such edge exists.
	 */
	public void followEdgeInReverse(int e) {
		for (int i = 0; i < currentVertex.inList.size(); i++) {
			Neighbor neighbor = currentVertex.inList.get(i);
			if (neighbor.edge == e) {
				currentVertex = neighbor.vertex;
				return;
			}
		}
		System.out.println("Edge from " + e + " does not exist.");
	}

	/*
	 * Insert a directed edge from v to current vertex with label e, or change
	 * the label of existing such edge to e.
	 */
	public void addEdgeFrom(char v, int e) {
		// does an edge from v already exist?
		for (int i = 0; i < currentVertex.inList.size(); i++) {
			Neighbor neighbor = currentVertex.inList.get(i);
			if (currentVertex.inList.get(i).vertex.label == v) {
				neighbor.edge = e; 
				findNeighbor(findVertex(v).outList, currentVertex.label).edge = e;
				return;
			}
		}

		// add to current's inList
		Neighbor newNeighbor = new Neighbor(findVertex(v), e);
		currentVertex.inList.add(newNeighbor);

		// add to neighbor's outList
		Neighbor current = new Neighbor(currentVertex, e);
		newNeighbor.vertex.outList.add(current);

		edges++;
	}

	/*
	 * Insert a directed edge from current vertex to v with label e, or change
	 * the label of existing such edge to e.
	 */
	void addEdgeTo(char v, int e) {
		// does an edge to v already exist?
		for (int i = 0; i < currentVertex.outList.size(); i++) {
			Neighbor neighbor = currentVertex.outList.get(i);
			if (neighbor.vertex.label == v) {
				neighbor.edge = e;
				findNeighbor(findVertex(v).inList, currentVertex.label).edge = e;
				return;
			}
		}

		// add to current's inList
		Neighbor newNeighbor = new Neighbor(findVertex(v), e);
		currentVertex.outList.add(newNeighbor);

		// add to neighbor's outList
		Neighbor current = new Neighbor(currentVertex, e);
		newNeighbor.vertex.inList.add(current);

		edges++;
	}

	/*
	 * Return true if there exists an edge from v to current vertex, otherwise
	 * return false.
	 */
	public boolean hasEdgeFrom(char v) {
		for (int i = 0; i < currentVertex.inList.size(); i++) {
			Neighbor neighbor = currentVertex.inList.get(i);
			if (neighbor.vertex.label == v)
				return true;
		}
		return false;
	}

	/*
	 * Return true if there exists an edge to v from current vertex, otherwise
	 * return false.
	 */
	public boolean hasEdgeTo(char v) {
		for (int i = 0; i < currentVertex.outList.size(); i++) {
			Neighbor neighbor = currentVertex.outList.get(i);
			if (neighbor.vertex.label == v)
				return true;
		}
		return false;
	}

	/*
	 * Print the label of the edge from v to current vertex, if such edge
	 * exists, and otherwise print “none”
	 */
	public void findEdgeFrom(char v) {
		for (int i = 0; i < currentVertex.inList.size(); i++) {
			Neighbor neighbor = currentVertex.inList.get(i);
			if (neighbor.vertex.label == v) {
				System.out.println(neighbor.edge);
				return;
			}
		}
		System.out.println("none");
	}

	/*
	 * Print the label of the edge from current vertex to v, if such edge
	 * exists, and otherwise print “none”
	 */
	public void findEdgeTo(char v) {
		for (int i = 0; i < currentVertex.outList.size(); i++) {
			Neighbor neighbor = currentVertex.outList.get(i);
			if (neighbor.vertex.label == v) {
				System.out.println(neighbor.edge);
				return;
			}
		}
		System.out.println("none");
	}

	/*
	 * Remove the edge from v to current vertex, if such edge exists.
	 */
	public void removeEdgeTo(char v) {
		for (int i = 0; i < currentVertex.outList.size(); i++) {
			Neighbor neighbor = currentVertex.outList.get(i);
			if (neighbor.vertex.label == v) {
				// remove from neighbor's inList
				neighbor.vertex.inList.remove(findNeighbor(neighbor.vertex.inList, currentVertex.label)); 														
				currentVertex.outList.remove(neighbor); // remove from current's outList
				return;
			}
		}
		System.out.println("Edge to " + v + " does not exist.");
	}

	/*
	 * remove the edge from v to current vertex, if such edge exists.
	 */
	public void removeEdgeFrom(char v) {
		for (int i = 0; i < currentVertex.inList.size(); i++) {
			Neighbor neighbor = currentVertex.inList.get(i);
			if (neighbor.vertex.label == v) {
				// remove from neighbor's outList
				neighbor.vertex.outList.remove(findNeighbor(neighbor.vertex.outList, currentVertex.label)); 		
				currentVertex.inList.remove(neighbor); // remove from current's inList
				return;
			}
		}

		System.out.println("Edge from " + v + " does not exist.");
	}

	/*
	 * Print the labels of vertices in the order encountered during a
	 * breadth-first search starting at current node.
	 */
	public void BFS() {
		Queue queue = new Queue();
		queue.enqueue(this.currentVertex);
		currentVertex.printVertex();
		currentVertex.visited = true;
		while (!queue.isEmpty()) {
			Vertex vertex = (Vertex) queue.dequeue();
			Vertex child = null;
			while ((child = getUnvisitedChildVertex(vertex)) != null) {
				child.visited = true;
				child.printVertex();
				queue.enqueue(child);
			}
		}
		clearVertexNodes();
		printLine();
	}

	private Vertex getUnvisitedChildVertex(Vertex x) {		
		for (int i = 0; i < x.outList.size(); i++) {
			Neighbor neighbor = x.outList.get(i);
			if (neighbor.vertex.visited == false) {
				return neighbor.vertex;
			}
		}
		return null;
	}

	public void DFS() {
		Stack stack = new Stack();
		stack.push(this.currentVertex);
		currentVertex.visited = true;
		currentVertex.printVertex();
		while (!stack.isEmpty()) {
			Vertex vertex = (Vertex) stack.top();
			Vertex child = getUnvisitedChildVertex(vertex);
			if (child != null) {
				child.visited = true;
				child.printVertex();
				stack.push(child);
			} else {
				stack.pop();
			}
		}
		clearVertexNodes();
		printLine();
	}

	private void clearVertexNodes() {
		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).visited = false;
		}
	}

	/* 
	 * Pass start vertex and an array that tells us if
	 * we've seen a vertex.
	 */
	private void DFS(Vertex x) {
		seen[vertices.indexOf(x)] = true;
		System.out.print(x.label + " ");
		for (int i = 0; i < x.outList.size(); i++) {
			if (!seen[vertices.indexOf(x.outList.get(i).vertex)]) {
				DFS(x);
			}
		}
	}
}
