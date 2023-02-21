package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maze.MazeBox;

public class ShortestPathsImpl extends HashMap<Vertex,Vertex> implements graph.ShortestPaths{
	
	public ShortestPathsImpl() {
		super();
	}
	
	/**To get the predecessur of a vertex in a shortest path to reconstruct the shortest path from end point until starting point
	 * Every vertex has a predecessor to reach the vertex
	 * @param vertex 
	 * @return predecesseur of vertex given
	 */
	public Vertex getPredecesseur(Vertex vertex) {
		return get(vertex);
	}
	
	/**
	 * To add a pair of element of (vertex,previous vertex)into ShoretstPath
	 * This is used in Dijsktra algorithm to find the shortest path
	 * @param vertex
	 * @param prevVertex
	 */
	public void setPrevious(Vertex vertex, Vertex prevVertex) {
		put(vertex, prevVertex);
	}

	/**
	 * To constuct a shortest path, starting from arrival box given in parameter, find its predecessor and continue the same process until 
	 * it reaches the departure box. As there may have additional vertexes in ShortestPaths which are not used to construct the shortest path.
	 * @param endVertex
	 * @return a list of vertexes consisting the vertexes of shortest path
	 */
	public List<Vertex> getShortestPath(Vertex endVertex) {
		List<Vertex> shortestPathVertex = new ArrayList<Vertex>();
		Vertex currentVertex = endVertex;

		//Get the predecesseur for each current vertex until it arrives the start vertex
		while(currentVertex != null) {
			shortestPathVertex.add(currentVertex);
			currentVertex = get(currentVertex);
		}
		return shortestPathVertex;
	}
	
	/**
	 * To get the total number of elements (in pair) in ShortestPaths
	 * @return length of ShortestPaths
	 */
	public int getSize() {
		return size();
	}
}
