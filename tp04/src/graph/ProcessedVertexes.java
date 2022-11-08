package graph;

public interface ProcessedVertexes {
	
	//To add a vertex into ensemble of processedVertex
	public void addProcessedVertex (Vertex vertex);
	
	//To find if a vertex is in processedVertexes
	public boolean containVertex (Vertex vertex);
	
	//To get a processed vertex
	public Vertex getProcessedVertex(int i);
	
}
