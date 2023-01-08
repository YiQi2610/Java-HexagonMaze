package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPathsImpl implements graph.ShortestPaths{
	Map<Vertex, Vertex> shortestPath = new HashMap<Vertex, Vertex>();

	public Vertex getPredecesseur(Vertex vertex) {
		return shortestPath.get(vertex);
	}
	
	//Save the previous vertex of shortest path
	public void setPrevious(Vertex vertex, Vertex prevVertex) {
		shortestPath.put(vertex, prevVertex);
	}

	@Override
	public List<Vertex> getShortestPath(Vertex endVertex) {
		List<Vertex> shortestPathVertex = new ArrayList<Vertex>();
		Vertex currentVertex = endVertex;
		
		//Add endvertex into list of shortestPathVertex
		shortestPathVertex.add(endVertex);
		
		//Get the predecesseur for each current vertex until it arrives the start vertex
		while(shortestPath.get(currentVertex)!= null) {
			shortestPathVertex.add(shortestPath.get(currentVertex));
			currentVertex = shortestPath.get(currentVertex);
		}
		return shortestPathVertex;
	}
}
