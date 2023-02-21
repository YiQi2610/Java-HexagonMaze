package graph;

public interface ProcessedVertexes {
	
	/**To add a vertex into set of ProcessedVertexes
	 * If a vertex has already been verified, it will be added into set
	 * @param vertex
	 */
	public void addProcessedVertex (Vertex vertex);
	
	/**To find if a vertex is in processedVertexes
	 * @param vertex
	 * @return true or false
	 */
	public boolean containVertex (Vertex vertex);
	
	/**
	 * To get total number of vertex in ProcessedVertexes
	 * @return length of ProcessedVertexes
	 */
	public int numberProcessedVertexes ();
	
}
