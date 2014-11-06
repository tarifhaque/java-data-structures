import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

class TestGraph {
	
	public static void main(String args[]) {
		Graph G = new Graph();
		
		System.out.println("1. Read instructions from file.");
		System.out.println("2. Input instructions within program.");
		System.out.print("Select input method: ");
		
		Scanner reader = new Scanner(System.in);
		String selection = reader.next();
		if (selection.equals("1")) runInstructionsFromFile(G);
		else if (selection.equals("2")) allowUserToInputCommands(G);
		else System.out.println("Select a valid input option.");
	}

	/* Test that reads instructions input by the user */
	private static void allowUserToInputCommands(Graph G) {
		Scanner in = new Scanner(System.in);
		String userinput = "";
		
		System.out.println("Type \'exit\' to quit.");
		
		while (!userinput.equals("exit")) {
			System.out.print("Enter graph method: ");
			userinput = in.next();
			executeInstruction(G, userinput, in);
		}
	}
	
	/* Test that reads instructions from file. */
	private static void runInstructionsFromFile(Graph G) {
		Scanner input = null;
		try { input = new Scanner (new FileReader ("input2.txt")); } 
		catch (FileNotFoundException e) {
			System.out.println("Cannot find the input file.");
			System.exit(0);
		}
		
		while (input.hasNext()) {
			String x = input.next().toLowerCase();
			executeInstruction(G, x, input);
		}
	}

	private static void executeInstruction(Graph G, String x, Scanner input) {
		String param;
		int num;
		x = x.toLowerCase();
		char cv = G.currentVertex.label;
		switch(x) {
			case ("numedges"):
				System.out.println("Edges: " + G.numEdges());
				break;
				
			case ("gotovertex"):
				param = input.next();
				if (param.length() > 1) break;
				System.out.println("Set current vertex " + cv + " to " + param);
				G.gotoVertex(param.charAt(0));
				break;
			
			case ("indegree"):
				System.out.println("In degree of current vertex " + cv + ": " + G.inDegree());
				break;
			
			case ("outdegree"):
				System.out.println("Out degree of current vertex " + cv + ": " + G.outDegree());
				break;
			
			case ("inincidentedges"):
				System.out.print("Incoming incident edges of current vertex " + cv + ": ");
				G.inIncidentEdges();
				break;
			
			case ("outincidentedges"):
				System.out.print("Outgoing incident edges of current vertex " + cv + ": ");
				G.outIncidentEdges();
				break;
			
			case ("inadjacentvertices"):
				System.out.print("Incoming adjacent vertices of current vertex " + cv + ": ");
				G.inAdjacentVertices();
				break;
				
			case ("outadjacentvertices"):
				System.out.print("Outgoing adjacent vertices of current vertex " + cv + ": ");
				G.outAdjacentVertices();
				break;
				
			case ("findedgefrom"):
				param = input.next();
				if (param.length() > 1) break;
				System.out.print("Incoming edge from " + param + ": ");
				G.findEdgeFrom(param.charAt(0));
				break;
			
			case ("findedgeto"):
				param = input.next();
				if (param.length() > 1) break;
				System.out.print("Outgoing edge to " + param + ": ");
				G.findEdgeTo(param.charAt(0));
				break;
			
			case ("followedge"):
				num = input.nextInt();
				System.out.println("Follow out edge " + num + " from " + cv);
				G.followEdge(num);
				break;
			
			case ("followedgeinreverse"):
				num = input.nextInt();
				System.out.println("Follow edge " + num + " in reverse from " + cv);
				G.followEdgeInReverse(num);
				break;
			
			case ("addedgefrom"):
				param = input.next();
				num = input.nextInt();
				if (param.length() > 1) break;
				System.out.println("Add edge (" + num + ") from " + param + " to current vertex " + cv);
				G.addEdgeFrom(param.charAt(0), num);
				break;
			
			case ("addedgeto"):
				param = input.next();
				num = input.nextInt();
				if (param.length() > 1) break;
				System.out.println("Add edge (" + num + ") to " + param + " from current vertex " + cv);
				G.addEdgeTo(param.charAt(0), num);
				break;
			
			case ("hasedgefrom"):
				param = input.next();
				if (param.length() > 1) break;
				System.out.println("Current vertex " + cv + " has an edge from " + param + ": " +
						G.hasEdgeFrom(param.charAt(0)));
				break;
			
			case ("hasedgeto"):
				param = input.next();
				if (param.length() > 1) break;
				System.out.println("Current vertex " + cv + " has an edge to " + param + ": " + 
						G.hasEdgeTo(param.charAt(0)));
				break;
			
			case ("removeedgefrom"):
				param = input.next();
				if (param.length() > 1) break;
				G.removeEdgeFrom(param.charAt(0));
				break;
			
			case ("removeedgeto"):
				param = input.next();
				if (param.length() > 1) break;
				System.out.println("Remove edge to " + param + " from current vertex " + cv);
				G.removeEdgeTo(param.charAt(0));
				break;
			
			case("bfs"):
				System.out.print("Breadth First Search: ");
				G.BFS();
				break;
			
			case("dfs"):
				System.out.print("Depth First Search: ");
				G.DFS();
				break;
			
			case("exit"):
				break;
			
			default:
				System.out.println("Did not recognize command: " + x);
		}
	}
}