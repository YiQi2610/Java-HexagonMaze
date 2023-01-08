package maze;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import graph.MinDistance;
import graph.Vertex;

public class Maze implements graph.Graph {
	
	private int largeurMaze;
	private int longueurMaze;
	private MazeBox[][] labyrinthe;
	private MazeBox startBox;
	private MazeBox endBox;
 
	
	public Maze(int largeurMaze, int longueurMaze) {
		super();
		this.largeurMaze = largeurMaze;
		this.longueurMaze = longueurMaze; 
		this.labyrinthe = new MazeBox[largeurMaze][longueurMaze];
	}
	
	
	public int getLargeurMaze() {
		return largeurMaze;
	}


	public int getLongueurMaze() {
		return longueurMaze;
	}

	
	public MazeBox getStartBox() {
		return startBox;
	}


	public MazeBox getEndBox() {
		return endBox;
	}

	//Function of getting a list of neighbors of a mazebox
	public ArrayList <MazeBox> getNeighbours(MazeBox box) {
		ArrayList <MazeBox> boxNeighbours = new ArrayList <MazeBox>();
		
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

	//To get a list of all vertexes in graph by returning a list all vertexes in labyrinthe
	public List<Vertex> getAllVertexes() {
		List<Vertex> listAllVertex = new ArrayList<Vertex>();
		for (int i = 0; i<longueurMaze; i++) {
			for(int j=0; j<largeurMaze; j++) {
				listAllVertex.add(labyrinthe[j][i]);
			}
		}
		return listAllVertex;
	}
	
	//To get a list of sucessors of a vertex in graph
	public List<Vertex> getSuccessors(Vertex vertex) {
		List<Vertex> listSucessors = new ArrayList<Vertex>();
		List<MazeBox> listNeighbors = new ArrayList<MazeBox>();
		listNeighbors = getNeighbours((MazeBox) vertex);
		for(MazeBox box : listNeighbors) {
			if(!isWall(box)){
				listSucessors.add(box);
			}
		}
		return listSucessors;
	}

	//To get the weight between two vertexes
	public int getWeight(Vertex src, Vertex dst) {
		//If destination vertex is a wall box,we return infinity
		if(isWall((MazeBox)dst)) {
			return Integer.MAX_VALUE;
		}
		else { //If vertex destination is neighbour of vertex source, return 1 , if no, return 0
			List <Vertex> listNeighbours = new ArrayList<Vertex>();
			if (listNeighbours.contains(dst)) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}	
	
	public final void initFromTextFile(String fileName) throws MazeReadingException, Exception{
		/**try (
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
				}*/
		try (
		BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = br.readLine();
			int cpt = 0;
			while(cpt < this.getLongueurMaze()) {
				int lengthOfLine = line.length();
				//If the length of line not equals to length of maze, throw a new exception
				if(lengthOfLine != this.getLargeurMaze()) { throw new MazeReadingException(fileName,cpt+1); }
				else {
					for (int j = 0; j<lengthOfLine; j++) {
						if(line.charAt(j)=='D') {
							this.labyrinthe[cpt][j] = new DepartureBox(cpt,j,this);
							this.labyrinthe[cpt][j].setName('D');
							this.startBox = labyrinthe[cpt][j];
						}
						else if(line.charAt(j)=='E') {
							this.labyrinthe[cpt][j] = new EmptyBox(cpt,j,this);
							this.labyrinthe[cpt][j].setName('E');
						}
						else if(line.charAt(j)=='A') {
							this.labyrinthe[cpt][j] = new ArrivalBox(cpt,j,this);
							this.labyrinthe[cpt][j].setName('A');
							this.endBox = labyrinthe[cpt][j];
						}
						else if(line.charAt(j)=='W'){
							this.labyrinthe[cpt][j] = new WallBox(cpt,j,this);
							this.labyrinthe[cpt][j].setName('W');
						}
						else { //If none of these 4 caraceters in presented
							throw new MazeReadingException(fileName,cpt+1);
						}
					}
				}
				line = br.readLine();
				cpt++;
			}
			br.close();
		}
	}
	
	public final void saveToTextFile(String fileName) throws Exception {
		try (PrintWriter pw = new PrintWriter(fileName)) {
			for(int i = 0; i<this.getLongueurMaze(); i++) {
				for(int j = 0; j<this.getLargeurMaze(); j++) {
					pw.print(this.labyrinthe[i][j].getName());
					/*
					String className = this.labyrinthe[i][j].getClass().getSimpleName();
					if(className == "DepartureBox") {
						pw.print('D');
					}
					else if(className == "ArrivalBox") {
						pw.print('A');
					}
					else if(className == "EmptyBox") { //Change code here!!! Use getLabel
						pw.print('E');
					}
					else if(className == "WallBox") {
						pw.print('W');
					}
					else {
						throw new Exception();
					}*/
				}
				pw.print("\n");
			}
			pw.close();
		}
	}
	
	//To identify whether the mazebox is a wall box
	public boolean isWall(MazeBox box) {
		if(box.getName()=='W') {
			return true;
		}
		else { return false;}
	}
}
