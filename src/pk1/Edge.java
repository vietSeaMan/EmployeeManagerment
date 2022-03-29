/**
 * Edge class
 * To Create and manipulate Edge
 */
package pk1;

public class Edge {
	//weight of edge
	private int weight;
	//With v is start Vertex 
	private Vertex vVertex;
	//With u is end Vertex;
	private Vertex uVertex;
	
	/**
	 * Initialization Edge object
	 * @param vVertex
	 * @param uVertex
	 * @param weight
	 */
	public Edge(Vertex vVertex, Vertex uVertex, int weight) {
		this.uVertex = uVertex;
		this.vVertex = vVertex;
		this.weight = weight;
	}
	
	/**
	 * Methods to get weight , get uVertex, get vVertex 
	 * @return
	 */
	public int getWeight() {
		return weight;
	}

	public Vertex getuVertex() {
		return uVertex;
	}

	public Vertex getvVertex() {
		return vVertex;
	}
	
	/**
	 * Method to set weight of Edge, set vVertex, set uVertex
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setuVertex(Vertex uVertex) {
		this.uVertex = uVertex;
	}

	public void setvVertex(Vertex vVertex) {
		this.vVertex = vVertex;
	}

	@Override
	public String toString() {
		return "Eage(v= " + vVertex.getName() + ", u=" + uVertex.getName()+ ", weight=" + weight+")";
	}
	
	
}
