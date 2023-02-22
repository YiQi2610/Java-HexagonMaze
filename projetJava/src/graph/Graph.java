package graph;

import java.util.List;

public interface Graph {
		
	/**
	 * To get a list of all vertices in graph, used in Dijsktra to find next pivot
	 * @return a list of vertices
	 */
	public List<Vertex> getAllVertexes() ;
	
	/**
	 * To get a list of neighbouring vertices of a vertice in graph, used in Dijsktra to add elements in ShortestPaths
	 * @param vertex
	 * @return list of neighbouring vertices
	 */
	public List<Vertex> getSuccessors(Vertex vertex) ;
	
	/**
	 * To get the weight between two vertices, in our algorithm, weight between two vertices is always 1
	 * @param src
	 * @param dst
	 * @return weight
	 */
	public int getWeight(Vertex src,Vertex dst) ;

}
