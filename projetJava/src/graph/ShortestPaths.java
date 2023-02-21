package graph;

import java.util.List;

public interface ShortestPaths {

	/**To get the predecessur of a vertex in a shortest path to reconstruct the shortest path from end point until starting point
	 * @param vertex 
	 * @return predecesseur of vertex given
	 */
	public Vertex getPredecesseur (Vertex vertex);
	
	/**
	 * To add a pair of element of (vertex,previous vertex)into ShoretstPath
	 * This is used in Dijsktra algorithm to find the shortest path
	 * @param vertex
	 * @param prevVertex
	 */
	public void setPrevious(Vertex vertex, Vertex prevVertex);
	
	/**
	 * To constuct a shortest path, starting from arrival box given in parameter, find its predecessor and continue the same process until 
	 * it reaches the departure box. As there may have additional vertexes in ShortestPaths which are not used to construct the shortest path.
	 * @param endVertex
	 * @return a list of vertexes consisting the vertexes of shortest path
	 */
	List<Vertex> getShortestPath( Vertex endVertex );
	
	/**
	 * To get the total number of elements (in pair) in ShortestPaths
	 * @return length of ShortestPaths
	 */
	public int getSize();
}
