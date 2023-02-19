import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import graph.Dijkstra;
import graph.MinDistance;
import graph.MinDistanceImpl;
import graph.ProcessedVertexes;
import graph.ProcessedVertexesImpl;
import graph.ShortestPaths;
import graph.ShortestPathsImpl;
import graph.Vertex;
import maze.Maze;
import maze.MazeBox;
import maze.MazeReadingException;

public class Main {

	public static void main(String[] args) {
		Maze labyrinthe = new Maze(10,10);
		ShortestPaths result = new ShortestPathsImpl();
		ProcessedVertexes processedVertexes = new ProcessedVertexesImpl();
		MinDistance minDistance = new MinDistanceImpl();
		
		
		try {
			labyrinthe.initFromTextFile("data/labyrinthe.maze");
		} catch (MazeReadingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Vertex startVertex = labyrinthe.getStartBox();
		Vertex endVertex = labyrinthe.getEndBox();
		result = Dijkstra.dijkstra(labyrinthe,startVertex,endVertex,processedVertexes,minDistance,result );
		System.out.println(result);
		
		ArrayList<Vertex> resVertex = (ArrayList<Vertex>) result.getShortestPath(endVertex);
		System.out.println(resVertex);
		
		for(Vertex vertex : resVertex) {
			if(vertex!=null) {
				System.out.println(vertex.getLabel());
			}
		}
		
		labyrinthe.printMaze(resVertex);
	}

}
