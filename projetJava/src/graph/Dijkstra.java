package graph;

import java.util.ArrayList;
import java.util.List;

import maze.Maze;

public class Dijkstra {

	public static ShortestPaths dijkstra (Graph graph, Vertex startVertex, Vertex endVertex, ProcessedVertexes processedVertexes, MinDistance minDistance, ShortestPaths shortestPaths ) {

		//Set start vertex as pivot
		Vertex pivotVertex = startVertex;

		//Add start vertex into list of processed vertexes
		processedVertexes.addProcessedVertex(startVertex);

		//Add the other vertexes except start Vertex into list of notProcessed Vertex
		List<Vertex> notProcessedVertex = new ArrayList<Vertex>();
		notProcessedVertex = graph.getAllVertexes();
		notProcessedVertex.remove(startVertex);

		//Set start vertex with 0 as min distance
		minDistance.setMinDist(startVertex, 0);

		//Set all other vertexes with infinity as min distance as they haven't be treated
		for(Vertex vertex : notProcessedVertex) {
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

				//add the end vertex with its predecessor into shortest path
//				if(nextPivot == endVertex) {
//					shortestPaths.setPrevious(nextPivot, pivotVertex);
//				}

				//Set the next pivot vertex
				pivotVertex = nextPivot;

				//Add the next pivot in processed Vertexes and remove it from notProcessed Vertex
				processedVertexes.addProcessedVertex(pivotVertex);
		//		notProcessedVertex.remove(pivotVertex);
			}
		}

		//shortestPathRes = (ShortestPaths) shortestPaths.getShortestPath(endVertex);

		return shortestPaths ;
	}


}
