package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPathsImpl extends HashMap<Vertex,Vertex> implements graph.ShortestPaths{
	//Map<Vertex, Vertex> shortestPath = new HashMap<Vertex, Vertex>();
	
	public ShortestPathsImpl() {
		super();
	}
	
	public Vertex getPredecesseur(Vertex vertex) {
		return get(vertex);
	}
	
	//Save the previous vertex of shortest path
	public void setPrevious(Vertex vertex, Vertex prevVertex) {
		put(vertex, prevVertex);
	}

	@Override
	public List<Vertex> getShortestPath(Vertex endVertex) {
		List<Vertex> shortestPathVertex = new ArrayList<Vertex>();
		Vertex currentVertex = endVertex;
		
		//Add endvertex into list of shortestPathVertex
		shortestPathVertex.add(endVertex);
		
		//Get the predecesseur for each current vertex until it arrives the start vertex
		while(get(currentVertex)!= null) {
			shortestPathVertex.add(get(currentVertex));
			currentVertex = get(currentVertex);
		}
		return shortestPathVertex;
	}
	
	public int getSize() {
		return size();
	}
}
