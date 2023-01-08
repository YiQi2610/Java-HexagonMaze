package graph;

import java.util.HashSet;
import java.util.Set;

public class ProcessedVertexesImpl implements graph.ProcessedVertexes{
	
	Set<Vertex> processedVertexes = new HashSet<Vertex>();

	public void addProcessedVertex(Vertex vertex) {
		processedVertexes.add(vertex);
	}

	public boolean containVertex(Vertex vertex) {
		return processedVertexes.contains(vertex);
	}

	public int numberProcessedVertexes() {
		return processedVertexes.size();
	}


	
}
