package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import maze.MazeBox;

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

		//Get the predecesseur for each current vertex until it arrives the start vertex
		while(currentVertex != null) {
			shortestPathVertex.add(currentVertex);
			currentVertex = get(currentVertex);
		}
		return shortestPathVertex;
	}
	
	public int getSize() {
		return size();
	}
}
