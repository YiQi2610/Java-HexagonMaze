package graph;

public interface ShortestPaths {

	//To get the list of vertexes which constructs the shortest path from a startVertex to a certain vertex
	public ShortestPaths getVertexShortestPath(Vertex vertex);
	
	//To get total distance of shortest path from root to a certain vertex
	public double getTotalDist (Vertex vertex);
	
	
}
