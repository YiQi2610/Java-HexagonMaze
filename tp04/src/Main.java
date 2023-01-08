import graph.Dijkstra;
import graph.MinDistance;
import graph.ProcessedVertexes;
import graph.ShortestPaths;
import graph.Vertex;
import maze.Maze;
import maze.MazeBox;

public class Main {

	public static void main(String[] args) {
		Maze labyrinthe = new Maze(10,10);
		ShortestPaths result;
		ProcessedVertexes processedVertexes;
		MinDistance minDistance;
		
		
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
		
	}

}
