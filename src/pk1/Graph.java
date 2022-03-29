
/**
 * Graph class 
 * To Create and manipulate graphs
 * Include methods below:
 * + Initialization method.
 * + Add new Edge method.
 * + Print out graph
 * + Print out vertex using DFS algorithm
 * + Find a shortest way using Dijkstra's Algorithm
 * + Other sub method :  resetAllVertex(), showVertex(), findMinDist().
 */
package pk1;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Stack;

public class Graph {
	private ArrayList<Vertex> graph;
	private int numOfvertex;
	String str = "ABCDEFGH";
	private Stack<Vertex> myStack = new Stack<Vertex>();
	
	/**
	 * Initialization graph object
	 * @param numOfvertex is number of Vertex
	 */
	public Graph(int numOfvertex) {
		this.numOfvertex = numOfvertex;
		graph = new ArrayList<Vertex>();
		for(int i=0; i< numOfvertex; i++) {
			graph.add(new Vertex(str.charAt(i)));
		}
	} 
	
	/**
	 * Add new Edge to graph
	 * @param v
	 * @param u
	 * @param w
	 */
	public void addEdge(int v, int u, int w) {
		//create new Edge object and add this Edge to list of Edge in Vertex object
		Edge newEdge = new Edge(graph.get(v), graph.get(u), w);
		graph.get(v).addEdge(newEdge);
	}
	
	/**
	 * Method to print list of Vertex and Edge 
	 */
	public void printGraph() {
		for(Vertex x : graph) {
			System.out.println(x);
		}
		System.out.println("-------------------------------------");
	}
	
	
	/**
	 * Method to reset all the visited and distance parameter vertex
	 */
	public void resetAllVertex() {
		for(Vertex x : graph) {
			x.setVisited(false);
			x.setDist(9999);
		}
	}
	
	/**
	 * Depth First Search algorithm
	 * @param start
	 */
	public void DepthFirstSearch(Vertex start) {
		Vertex currentVertex = graph.get(str.indexOf(start.getName()));
		if(currentVertex.isVisited()) return;
		else {
			currentVertex.setVisited(true);
			System.out.print(currentVertex.getName()+" ");
			
			//If vertex has no start Edge then stop method
			if(currentVertex.getListEdge()==null) return;
			for(Edge x : currentVertex.getListEdge()) {
				DepthFirstSearch(x.getuVertex());
			}
		}
	}
	
	
	/**
	 *call Depth First Search  Method
	 */
	public void showVertex(char start) {
		//Call DFS method
		DepthFirstSearch(graph.get(str.indexOf(start)));
		System.out.println();
		
		//to reset all the visited vertex
		resetAllVertex();
	}
	
	/**
	 * Find Shortest Way using Dijkstra's Algorithm
	 * @param start
	 * @param end
	 */
	public void findShortestWay(char start, char end) {
		//Get vertex start
		Vertex vertexStart = graph.get(str.indexOf(start));
		//Get vertex end
		Vertex vertexEnd = graph.get(str.indexOf(end));
		//Set current Vertex is start vertex
		Vertex currentVertex = vertexStart;
		//set Distance parameter for start vertex is zero (0)
		currentVertex.setDist(0);
		//set found variable to false
		boolean found = false;
		
		//while loop ends when target vertex is found or all the vertex can visit already visited
		while(found == false && currentVertex.isVisited()==false) {
			//IF target vertex is found then break from this loop
			if(currentVertex.getName() == vertexEnd.getName()) {
				found = true; 
				break;
			}
			
			//Print name of current vertex  
			System.out.print(currentVertex.getName() + " -> ");
			
			//set state of current vertex to visited
			currentVertex.setVisited(true);
			
			//If current Vertex have no way out then break from the loop
			if(currentVertex.getListEdge()==null) break;
			
			//Use for loop to get all the Edge from the current vertex
			for(Edge x : currentVertex.getListEdge()) {
				//Only calculator vertex is not visit yet 
				//Get u vertex from each Edge 
				if(x.getuVertex().isVisited()== false) {
					//Get new estimate of distance 
					int estimate = currentVertex.getDist() + x.getWeight();
					//if estimate less than current dust of vertex then update distance value for this vertex and update prev vertex for this vertex
					if(estimate < x.getuVertex().getDist()) {
						x.getuVertex().setDist(estimate);
						x.getuVertex().setPrev(currentVertex);
					}
				}
			}
			
			//set nextVertex is vertex have smallest distance parameter (Use findMinDist method, see this method in below)
			Vertex nextVertex = findMinDist(currentVertex.getListEdge());
			
			//If cannot choose any next Vertex or nextVertex is null then come back to prev Vertex and chose the orther vertex
			if(nextVertex == null) {
				currentVertex = currentVertex.getPrev();
				currentVertex.setVisited(false);
				
			}
			
			//if nextVertex has chosen 
			else {
				//Update current vertex is next Vertex
				currentVertex = nextVertex;		
			}
			System.out.println(currentVertex.getName() + " | Distance form "+ start + " to " +  currentVertex.getName() + " is : "+currentVertex.getDist());
		}
		
		
		//If found is false mean there no way from star vertex to end vertex
		if(found==false) System.out.println("there is no way from " + start + " to " + end);
		else {
			
			//push all the vertex in the path to stack
			Vertex temp = vertexEnd.getPrev();
			while(temp != null) {
				myStack.push(temp);
				temp = temp.getPrev();
			}
			System.out.print("The path is: ");
			
			//get vertex from the stack and print out
			while(!myStack.isEmpty()) {
				System.out.print(myStack.pop().getName() + "->");
			}
			System.out.print(vertexEnd.getName());
			System.out.println();
		}
		
		//reset all vertex in graph 
		resetAllVertex();
 	}
	
	/**
	 * Method to chose vertex have smallest distance parameter from the list of Edge in one Vertex object
	 * @param list
	 * @return
	 */
	public Vertex findMinDist(ArrayList<Edge> list) {
		//return null if list is empty
		if(list.isEmpty()) return null;
		else {
			Vertex result = null;
			int min = 9999;
			
			//only update min value when vertex not visited
			for(Edge x : list) {
				if(min > x.getuVertex().getDist() && x.getuVertex().isVisited() == false)  min = x.getuVertex().getDist();
			}
			
			//find the vertex 
			for(Edge x : list) {
				if(min == x.getuVertex().getDist()) result = x.getuVertex();
			}
			return result;
		}
		
	}

}
