package maze;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import graph.MinDistance;
import graph.Vertex;
import view.Hexagon;
import view.MazePanel;

public class Maze implements graph.Graph {

	private int largeurMaze;
	private int longueurMaze;
	private MazeBox[][] labyrinthe;
	private MazeBox startBox;
	private MazeBox endBox;
	private boolean modified =  false;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();


	public Maze(int largeurMaze, int longueurMaze) {
		super();
		this.largeurMaze = largeurMaze;
		this.longueurMaze = longueurMaze; 
		this.labyrinthe = new MazeBox[longueurMaze][largeurMaze];
	}

	public Maze() {
		super();
		this.largeurMaze = 10;
		this.longueurMaze = 10; 
		this.labyrinthe = new MazeBox[longueurMaze][largeurMaze];
		for(int row = 0; row<longueurMaze ; row++) {
			for(int col = 0; col<largeurMaze; col++) {
				labyrinthe[row][col] = new EmptyBox(row, col,this);
			}
		}
	}
	
	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for(ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}
	
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	
	public boolean isModified() {
		return modified;
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
		
	public MazeBox[][] getLabyrinthe() {
		return labyrinthe;
	}
	
	public void setStartBox(MazeBox startBox) {
		this.startBox = startBox;
		stateChanges();
	}

	public void setEndBox(MazeBox endBox) {
		this.endBox = endBox;
		stateChanges();
	}

	public void setLargeurMaze(int largeurMaze) {
		this.largeurMaze = largeurMaze;
		modified = true ; 
		stateChanges();
	}

	public void setLongueurMaze(int longueurMaze) {
		this.longueurMaze = longueurMaze;
		modified = true ; 
		stateChanges();
	}

	public void setLabyrinthe(MazeBox[][] labyrinthe) {
		this.labyrinthe = labyrinthe;
		modified = true ; 
		stateChanges();
	}

	public void createHexagonMaze(Graphics graphics){
		int radius = 0;
		if(largeurMaze>=longueurMaze) {
			radius = 1000/(largeurMaze*2);
		}
		else {
			radius = 1000/(longueurMaze*2);
		}
		for(int row=0; row<longueurMaze; row++) {
			for(int col=0; col<largeurMaze; col++) {	

				int cx = (int)(col*radius*1.5+radius);
				int cy = (int)(int)((row*0.75*radius*Math.sqrt(3)+radius*Math.sqrt(3)/2));
				if(row % 2 != 0) {
					cx += (0.75*radius);
				}
				this.labyrinthe[row][col].paint(graphics,radius,new Point(cx,cy));
			}
		}

	}

	public void printMaze(ArrayList<Vertex> shortestPath) {
		for(int i=0; i<this.longueurMaze; i++) {
			for(int j=0; j<this.largeurMaze; j++) {
				if(shortestPath.contains(labyrinthe[i][j]) && labyrinthe[i][j]!=startBox && labyrinthe[i][j]!=endBox ) {
					System.out.print("*");
				}
				else {System.out.print(labyrinthe[i][j].getName());}
			}
			System.out.println();
		}
	}

	//Function of getting a list of successors of a mazebox
	public List<Vertex> getSuccessors(Vertex vertex) {
		List <Vertex> boxNeighbours = new ArrayList <Vertex>();

		int xCoord = ((MazeBox)vertex).getxBox();
		int yCoord = ((MazeBox)vertex).getyBox();
		Maze refLabyrinthe = ((MazeBox)vertex).getRefLabyrinthe();

		try {
			MazeBox rNeighbour = labyrinthe[xCoord+1][yCoord];
			if(!rNeighbour.isWall()) {
				boxNeighbours.add(rNeighbour);
			}}catch( Exception e) {};
			try {
				MazeBox lNeighbour = labyrinthe[xCoord-1][yCoord];
				if(!lNeighbour.isWall()) {
					boxNeighbours.add(lNeighbour);
				}}catch( Exception e) {};
				try {
					MazeBox ulNeighbour = labyrinthe[xCoord][yCoord-1];
					if(!ulNeighbour.isWall()) {
						boxNeighbours.add(ulNeighbour);
					}}catch( Exception e) {};
					try {
						MazeBox dlNeighbour = labyrinthe[xCoord][yCoord+1];
						if(!dlNeighbour.isWall()) {
							boxNeighbours.add(dlNeighbour);
						}}catch( Exception e) {};
						try {
							MazeBox urNeighbour = labyrinthe[xCoord+1][yCoord-1];
							if(!urNeighbour.isWall()) {
								boxNeighbours.add(urNeighbour);
							}}catch( Exception e) {};
							try {
								MazeBox drNeighbour = labyrinthe[xCoord+1][yCoord+1];
								if(!drNeighbour.isWall()) {
									boxNeighbours.add(drNeighbour);
								}}catch( Exception e) {};

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
	/*public List<Vertex> getSuccessors(Vertex vertex) {
		List<Vertex> listSucessors = new ArrayList<Vertex>();
		List<MazeBox> listNeighbors = new ArrayList<MazeBox>();
		listNeighbors = getNeighbours((MazeBox) vertex);
		for(MazeBox box : listNeighbors) {
			if(!box.isWall() && box!=null){
				listSucessors.add(box);
			}
		}
		return listSucessors;
	}*/

	//To get the weight between two vertexes
	public int getWeight(Vertex src, Vertex dst) {
		return 1;
	}	

	public final void initFromTextFile(String fileName) throws MazeReadingException, Exception{
		try (
				BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
			
			int[] dimension = new int[2];		
			dimension = findDimension(fileName);
			
			setLargeurMaze(dimension[0]);
			setLongueurMaze(dimension[1]);
			MazeBox[][] newLabyrinthe = new EmptyBox[dimension[1]][dimension[0]];
			String line = br.readLine();
			int row = 0;			
			while(row<dimension[1]) { 
				int col = 0;
				while(col<dimension[0]) {
					if(line.charAt(col)=='D') {
						newLabyrinthe[row][col] = new DepartureBox (row,col,this);
						//newLabyrinthe[row][col].setName('D');
						this.startBox = labyrinthe[row][col];
					}
					else if(line.charAt(col)=='E') {
						newLabyrinthe[row][col] = new EmptyBox(row,col,this);
						//newLabyrinthe[row][col].setName('E');
					}
					else if(line.charAt(col)=='A') {
						newLabyrinthe[row][col] = new ArrivalBox(row,col,this);
						//newLabyrinthe[row][col].setName('A');
						this.endBox = labyrinthe[row][col];
					}
					else if(line.charAt(col)=='W'){
						newLabyrinthe[row][col] = new WallBox(row,col,this);
						//newLabyrinthe[row][col].setName('W');
					}
					else { //If none of these 4 caraceters in presented
						throw new MazeReadingException(fileName,row+1,"Invalid label of Mazebox");
					}
					col++;
				}
				line = br.readLine();
				row++;	
			}

			this.setLabyrinthe(newLabyrinthe);
			br.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public final void saveToTextFile(String fileName) throws Exception {
		try (PrintWriter pw = new PrintWriter("data/"+fileName)) {
			for(int i = 0; i<this.getLongueurMaze(); i++) {
				for(int j = 0; j<this.getLargeurMaze(); j++) {
					pw.print(this.labyrinthe[i][j].getName());
				}
				pw.print("\n");
			}
			pw.close();
		}
	}

	public void setDimension(int widthGiven, int heightGiven) {
		this.setLargeurMaze(widthGiven);
		this.setLongueurMaze(heightGiven);

		MazeBox[][] newLabyrinthe = new EmptyBox[heightGiven][widthGiven];
		for(int row = 0; row<heightGiven ; row++) {
			for(int col = 0; col<widthGiven; col++) {
				newLabyrinthe[row][col] = new EmptyBox(row, col,this);
			}
		}
		this.setLabyrinthe(newLabyrinthe);
	}
	
	public int[] findDimension(String fileName) throws MazeReadingException {
		int[] dimension = new int[2];
		dimension[0] = 0;
		dimension[1] = 1;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {		
			String line = br.readLine();
			if(line == null) {
				throw new MazeReadingException(fileName, 1, "Empty file");
			}
			dimension[0] =line.length();
			String row;
			while ((row=br.readLine()) != null) {dimension[1]++;}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return dimension;		
	}

	public char selectedHexagon(String typeOfHexagon) {
		if(typeOfHexagon == "departure") {return 'D';}
		else if(typeOfHexagon == "arrival") {return 'A';}
		else if(typeOfHexagon == "wall") {return 'W';}
		else {return 'E';}
	}


}
