import maze.Maze;
import maze.MazeReadingException;

public class MainTest {

	public static void main(String[] args) {
		Maze labyrintheTest = new Maze(10,10);
		try {
			labyrintheTest.initFromTextFile("data/labyrinthe.maze");
		} catch (MazeReadingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			labyrintheTest.saveToTextFile("data/labyrinthe2.maze");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
}
