package graph;

import java.util.List;

public interface ShortestPaths {

	//To get the predecessur of a vertex in a shortest path
	public Vertex getPredecesseur (Vertex vertex);
	
	public void setPrevious(Vertex vertex, Vertex prevVertex);
	
	List<Vertex> getShortestPath( Vertex endVertex );
}
