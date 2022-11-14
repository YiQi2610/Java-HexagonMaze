import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import graph.Vertex;

public class Maze implements graph.Graph {
	
	private int largeurMaze;
	private int longueurMaze;
	private MazeBox[][] labyrinthe;
 
	
	public Maze(int largeurMaze, int longueurMaze) {
		super();
		this.largeurMaze = largeurMaze;
		this.longueurMaze = longueurMaze; 
		this.labyrinthe = new MazeBox[largeurMaze][longueurMaze];
	}
	
	//Function of getting a list of neighbors of a mazebox
	public ArrayList <MazeBox> getNeighbours(MazeBox box) {
		ArrayList <MazeBox> boxNeighbours = null;
		
		int xCoord = box.getxBox();
		int yCoord = box.getyBox();
		Maze refLabyrinthe = box.getRefLabyrinthe();
		
		//If the box selected is the first box
		if(xCoord == 0 && yCoord == 0) { 
			boxNeighbours.add(refLabyrinthe.labyrinthe[1][0]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[1][0]);
		}
		
		//If the box selected is the last box
		if(xCoord == largeurMaze-1 && yCoord == longueurMaze-1) { 
			boxNeighbours.add(refLabyrinthe.labyrinthe[largeurMaze-2][longueurMaze-1]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[largeurMaze-1][longueurMaze-2]);
		}
		
		//If the box selected is at last position of first row
		if(xCoord == largeurMaze-1 && yCoord == 0) { 
			boxNeighbours.add(refLabyrinthe.labyrinthe[largeurMaze-2][0]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[largeurMaze-1][1]);
		}
		
		//If the box selected is at first position of last row
		if(xCoord == 0 && yCoord == longueurMaze-1) { 
			boxNeighbours.add(refLabyrinthe.labyrinthe[0][longueurMaze-2]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[1][longueurMaze-1]);
		}
		
		//If the box selected is at first row or at last row
		else if(yCoord == 0 || yCoord == largeurMaze-1) { 
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord-1][yCoord]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord+1][yCoord]);
			if(yCoord == 0) {boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord][yCoord+1]);}
			else if (yCoord == largeurMaze-1){boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord][yCoord-1]);}
		}
		
		//If the box selected is at first column or at last column
		else if(xCoord == 0 || xCoord == longueurMaze-1) { 
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord][yCoord-1]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord][yCoord+1]);
			if(xCoord == 0) {boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord+1][yCoord]);}
			else if (xCoord == longueurMaze-1){boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord-1][yCoord]);}
		}
		
		//If the box selected is inside labyrinth which has four neighbors
		else {
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord][yCoord-1]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord][yCoord+1]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord-1][yCoord]);
			boxNeighbours.add(refLabyrinthe.labyrinthe[xCoord+1][yCoord]);
		}
		
		return boxNeighbours;	
	}

	@Override
	public List<Vertex> getAllVertexes() {
		List<Vertex> listAllVertex = new ArrayList<Vertex>();
		for (int i = 0; i<longueurMaze; i++) {
			for(int j=0; j<largeurMaze; j++) {
				listAllVertex.add(labyrinthe[j][i]);
			}
		}
		return listAllVertex;
	}

	@Override
	public List<Vertex> getSuccessors(Vertex vertex) {
		List<Vertex> listSucessors = new ArrayList<Vertex>();;
		MazeBox box = (MazeBox) vertex ;
		return listSucessors;
	}

	@Override
	public int getWeight(Vertex src, Vertex dst) {
		int weight = 0;
		return weight;
	}	
	
	public final void initFromTextFile(String fileName) throws MazeReadingException{
		try (
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		){
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
