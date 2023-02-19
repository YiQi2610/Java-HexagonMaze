package graph;

public interface ProcessedVertexes {
	
	//To add a vertex into ensemble of processedVertex
	public void addProcessedVertex (Vertex vertex);
	
	//To find if a vertex is in processedVertexes
	public boolean containVertex (Vertex vertex);
	
	//To get number of processed vertex
	public int numberProcessedVertexes ();
	
}
