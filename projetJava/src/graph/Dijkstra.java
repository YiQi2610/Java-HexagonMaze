package graph;

import java.util.ArrayList;
import java.util.List;

import maze.Maze;

public class Dijkstra {

	/**
	 * Djikstra algorithm to construct a shortest path from a starting point to an end point, here we find the mazeboxes connecting arrival box and departure box with minimum number of boxes
	 * @param graph
	 * @param startVertex
	 * @param endVertex
	 * @param processedVertexes
	 * @param minDistance
	 * @param shortestPaths
	 * @return HashMap of shortestPaths with pairs of vertices selected
	 */
	public static ShortestPaths dijkstra (Graph graph, Vertex startVertex, Vertex endVertex, ProcessedVertexes processedVertexes, MinDistance minDistance, ShortestPaths shortestPaths ) {

		//Set start vertex as pivot
		Vertex pivotVertex = startVertex;

		//Add start vertex into list of processed vertexes
		processedVertexes.addProcessedVertex(startVertex);

		//Add the other vertexes except start Vertex into list of allVertexes
		List<Vertex> allVertexes = new ArrayList<Vertex>();
		allVertexes = graph.getAllVertexes();
		allVertexes.remove(startVertex);

		//Set start vertex with 0 as min distance
		minDistance.setMinDist(startVertex, 0);

		//Set all other vertexes with infinity as min distance as they haven't be treated
		for(Vertex vertex : allVertexes) {
			minDistance.setMinDist(vertex,Integer.MAX_VALUE);
		}

		//Repeat the loop if processedVertexes doesn't contain endVertex
		while(!processedVertexes.containVertex(endVertex) && pivotVertex !=null) {

			//Get a list of successor vertex of pivot
			List<Vertex> succVertex = new ArrayList<Vertex>();
			succVertex = graph.getSuccessors(pivotVertex);

			if(succVertex!=null) {
				for(Vertex successor : succVertex) {
					//If the succesor is not yet being processed
					if(!processedVertexes.containVertex(successor)){
						if(minDistance.getminDistance(pivotVertex) + graph.getWeight(pivotVertex,successor)< minDistance.getminDistance(successor)) {
							minDistance.setMinDist(successor,(int) (minDistance.getminDistance(pivotVertex) + graph.getWeight(pivotVertex,successor)));
							shortestPaths.setPrevious(successor,pivotVertex);
						}
					}
				}

				//Find next vertex which is not a processed vertex and also a neighbour vertex with minimum distance
				int minDist = Integer.MAX_VALUE;
				Vertex nextPivot = null;
				for(Vertex successor : graph.getAllVertexes()) {
					//To verify if the successor has been processed
					if(!processedVertexes.containVertex(successor)) {
						//To get the next pivot with minimum distance by comparing minimum distances among successors
						if(minDistance.getminDistance(successor)<minDist) {
							minDist = minDistance.getminDistance(successor);
							nextPivot = successor;
						}
					}
				}


				//Set the next pivot vertex
				pivotVertex = nextPivot;

				//Add the next pivot in processed Vertexes and remove it from notProcessed Vertex
				processedVertexes.addProcessedVertex(pivotVertex);
			}
		}
		return shortestPaths ;
	}
}
