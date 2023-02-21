package graph;

import java.util.HashSet;
import java.util.Set;

public class ProcessedVertexesImpl extends HashSet<Vertex> implements graph.ProcessedVertexes{

	public ProcessedVertexesImpl() {
		super();
	}
	
	/**To add a vertex into set of ProcessedVertexes
	 * If a vertex has already been verified, it will be added into set
	 * @param vertex
	 */
	public void addProcessedVertex(Vertex vertex) {
		add(vertex);
	}
	
	/**To find if a vertex is in processedVertexes
	 * @param vertex
	 * @return true or false
	 */
	public boolean containVertex(Vertex vertex) {
		return contains(vertex);
	}
	
	/**
	 * To get total number of vertex in ProcessedVertexes
	 * @return length of ProcessedVertexes
	 */
	public int numberProcessedVertexes() {
		return size();
	}


	
}
