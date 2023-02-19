package graph;

import java.util.HashSet;
import java.util.Set;

public class ProcessedVertexesImpl extends HashSet<Vertex> implements graph.ProcessedVertexes{
	
	//Set<Vertex> processedVertexes = new HashSet<Vertex>();
	public ProcessedVertexesImpl() {
		super();
	}
	public void addProcessedVertex(Vertex vertex) {
		add(vertex);
	}

	public boolean containVertex(Vertex vertex) {
		return contains(vertex);
	}

	public int numberProcessedVertexes() {
		return size();
	}


	
}
