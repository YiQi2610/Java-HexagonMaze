package graph;

public class Dijkstra {

	private ShortestPaths shortestPath;
	private Vertex pivotVertex;
			
	public ShortestPaths dijkstra (Graph graph, Vertex startVertex, Vertex endVertex, ProcessedVertexes processedVertexes, Distance distance, MinDistance minDistance ) {
		processedVertexes.addProcessedVertex(startVertex);
		pivotVertex = startVertex;
		minDistance.setMinDist(startVertex, 0);
		
		for(int i =0; i<graph.getNumberVertex(); i++) {
			if(graph.getVertex(i) != startVertex) {
				minDistance.setMinDist(graph.getVertex(i),100000);
			}
		}
		
		while(!processedVertexes.containVertex(endVertex)) {
			Vertex succVertex[] = pivotVertex.getSuccesors();
			if(succVertex!=null) {
				for(int j = 0; j<succVertex.length; j++) {
					if(!processedVertexes.containVertex(succVertex[j])){
						if(minDistance.getminDistance(pivotVertex) + distance.getDist(pivotVertex,succVertex[j])< minDistance.getminDistance(succVertex[j])) {
							minDistance.setMinDist(succVertex[j],(minDistance.getminDistance(pivotVertex) + distance.getDist(pivotVertex,succVertex[j])));
							succVertex[j].setPrevious(pivotVertex);
						}
					}
				}
			}
			
			pivotVertex = minDistance.getNextVertex();
			processedVertexes.addProcessedVertex(pivotVertex);
		}
		
		shortestPath = shortestPath.getVertexShortestPath(pivotVertex);
		return shortestPath ;
	}

	
}
