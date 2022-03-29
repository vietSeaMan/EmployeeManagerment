/**
 * Vertex class.
 * To Create and manipulate vertex
 * 
 */
package pk1;

import java.util.ArrayList;

public class Vertex {
	
	//Declare information store in class
	//name of vertex
	private char name;
	//list Edge out of vertex
	private ArrayList<Edge> listEdge;
	//State of visit, use for find a shortest way and print vertex with DFS algorithm
	private boolean visited;
	//Distance parameter
	private int dist;
	//Prev vertex for find a shortest way
	private Vertex prev;
	
	/**
	 * Initialization Vertex object
	 * @param name
	 */
	public Vertex(char name) {
		this.name = name;
		listEdge = new ArrayList<Edge>();
		this.dist = 9999;
	}
	
	/**
	 * add new Edge out from this vertex to list vertex
	 * @param newEdge
	 */
	public void addEdge(Edge newEdge) {
		this.listEdge.add(newEdge);
	}
	
	/**
	 * Get name of Vertex
	 * @return
	 */
	public char getName() {
		return name;
	}
	
	/**
	 * Set name of Vertex
	 * @param name
	 */
	public void setName(char name) {
		this.name = name;
	}
	
	/**
	 * get list of Edge in this vertex
	 * @return
	 */
	public ArrayList<Edge> getListEdge() {
		return listEdge;
	}

	/**
	 * get state of visit
	 * @return
	 */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * set state of visit
	 * @param visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * Get distance parameter
	 * @return
	 */
	public int getDist() {
		return dist;
	}
	
	/**
	 * get prev vertex of this vertex
	 * @return
	 */
	public Vertex getPrev() {
		return prev;
	}

	/**
	 * Set distance parameter 
	 * @param dist
	 */
	public void setDist(int dist) {
		this.dist = dist;
	}
	
	/**
	 * set prev vertex
	 * @param prev
	 */
	public void setPrev(Vertex prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return "Vertex [name=" + name + ", listEdge=" + listEdge + "]";
	}
	
	
}
