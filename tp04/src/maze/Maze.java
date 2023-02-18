package maze;
import java.awt.Color;
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

import graph.Dijkstra;
import graph.MinDistance;
import graph.MinDistanceImpl;
import graph.ProcessedVertexes;
import graph.ProcessedVertexesImpl;
import graph.ShortestPaths;
import graph.ShortestPathsImpl;
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
	private Color wallBoxColor;
	private Color arrBoxColor;
	private Color depBoxColor;
	private Color emptyBoxColor;
	private Color pathBoxColor;
	private int radiusHexgon;


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
		this.emptyBoxColor = Color.LIGHT_GRAY;
		this.wallBoxColor = Color.DARK_GRAY;
		this.depBoxColor = Color.RED;
		this.arrBoxColor = Color.BLUE;
		this.pathBoxColor = Color.GREEN;
		this.labyrinthe = new MazeBox[longueurMaze][largeurMaze];
		for(int row = 0; row<longueurMaze ; row++) {
			for(int col = 0; col<largeurMaze; col++) {
				labyrinthe[row][col] = new EmptyBox(row, col,this);
			}
		}
	}
	
	public void stateChanged() {
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
	
	public int getRadiusHexagon() {
		return radiusHexgon;
	}
		
	public MazeBox[][] getLabyrinthe() {
		return labyrinthe;
	}
	public Color getWallBoxColor() {return wallBoxColor;}

	public Color getArrBoxColor() {return arrBoxColor;}

	public Color getDepBoxColor() {return depBoxColor;}

	public Color getEmptyBoxColor() {return emptyBoxColor;}
	
	public Color getPathBoxColor() {return pathBoxColor;}

	public void setWallBoxColor(Color wallBoxColor) {
		this.wallBoxColor = wallBoxColor;
		modified = true ;
		stateChanged();
	}

	public void setArrBoxColor(Color arrBoxColor) {
		this.arrBoxColor = arrBoxColor;
		modified = true ;
		stateChanged();
	}

	public void setDepBoxColor(Color depBoxColor) {
		this.depBoxColor = depBoxColor;
		modified = true ;
		stateChanged();
	}

	public void setEmptyBoxColor(Color emptyBoxColor) {
		this.emptyBoxColor = emptyBoxColor;
		modified = true ;
		stateChanged();
	}
	
	public void setPathBoxColor(Color pathBoxColor) {
		this.pathBoxColor = pathBoxColor;
		modified = true ;
		stateChanged();
	}

	public void setStartBox(MazeBox startBox) {
		this.startBox = startBox;
		modified = true ;
		stateChanged();
	}

	public void setEndBox(MazeBox endBox) {
		this.endBox = endBox;
		modified = true ;
		stateChanged();
	}

	public void setLargeurMaze(int largeurMaze) {
		this.largeurMaze = largeurMaze;
		modified = true ; 
		stateChanged();
	}

	public void setLongueurMaze(int longueurMaze) {
		this.longueurMaze = longueurMaze;
		modified = true ; 
		stateChanged();
	}

	public void setLabyrinthe(MazeBox[][] labyrinthe) {
		this.labyrinthe = labyrinthe;
		modified = true ; 
		stateChanged();
	}
	
	public void setTypeBox(int row, int col, char type) {
		if(type == 'E') { this.labyrinthe[row][col] = new EmptyBox(row,col,this);}
		else if(type == 'W') { this.labyrinthe[row][col] = new WallBox(row,col,this);}
		else if(type == 'D') { this.labyrinthe[row][col] = new DepartureBox(row,col,this);}
		if(type == 'A') { this.labyrinthe[row][col] = new ArrivalBox(row,col,this);}
		modified = true ; 
		stateChanged();
	}

	public void createHexagonMaze(Graphics graphics){
		int radius = 0;
		Color color = null;
		if(largeurMaze>=longueurMaze) {
			radius = 1000/(largeurMaze*2);
		}
		else {
			radius = 1000/(longueurMaze*2);
		}
		this.radiusHexgon = radius;
		for(int row=0; row<longueurMaze; row++) {
			for(int col=0; col<largeurMaze; col++) {	
				int cx = (int)(col*radius*1.5+radius);
				int cy = (int)(int)((row*0.75*radius*Math.sqrt(3)+radius*Math.sqrt(3)/2));
				if(row % 2 != 0) {
					cx += (0.75*radius);
				}
				if(labyrinthe[row][col].getName()=='E' && !labyrinthe[row][col].isPath()) {color = getEmptyBoxColor();}
				else if (labyrinthe[row][col].getName()=='E' && labyrinthe[row][col].isPath()) {color = getPathBoxColor();}
				else if (labyrinthe[row][col].getName()=='W') {color = getWallBoxColor();}
				else if (labyrinthe[row][col].getName()=='A') {color = getArrBoxColor();}
				else if (labyrinthe[row][col].getName()=='D') {color = getDepBoxColor();}
				
				this.labyrinthe[row][col].paint(graphics,radius,new Point(cx,cy),color);
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
		
//		if(xCoord != largeurMaze-1) {
//			MazeBox rNeighbour = labyrinthe[xCoord+1][yCoord];
//			if(!rNeighbour.isWall() && rNeighbour != null) {
//				boxNeighbours.add(rNeighbour);
//			}
//		}
//		
//		if(xCoord != 0) {
//			MazeBox lNeighbour = labyrinthe[xCoord-1][yCoord];
//			if(!lNeighbour.isWall() && lNeighbour != null) {
//				boxNeighbours.add(lNeighbour);
//			}
//		}
//		
//		if(xCoord != 0 && (yCoord %2!=0 && xCoord!=0)) {
//			MazeBox ulNeighbour;
//			if(yCoord%2!=0) {ulNeighbour = labyrinthe[xCoord][yCoord-1];}
//			else{ulNeighbour = labyrinthe[xCoord-1][yCoord-1];}
//			if(!ulNeighbour.isWall() && ulNeighbour != null) {
//				boxNeighbours.add(ulNeighbour);
//			}
//		}
//		
//		if(yCoord != longueurMaze-1 && (yCoord %2!=0 && xCoord != 0)) {
//			MazeBox dlNeighbour;
//			if(yCoord%2!=0) {dlNeighbour = labyrinthe[xCoord][yCoord+1];}
//			else {dlNeighbour = labyrinthe[xCoord-1][yCoord+1];}
//			if(!dlNeighbour.isWall() && dlNeighbour != null) {
//				boxNeighbours.add(dlNeighbour);
//			}
//		}
//		
//		if(xCoord!=0 && (yCoord %2==0 && xCoord != largeurMaze-1) ) {
//			MazeBox urNeighbour;
//			if(yCoord%2!=0) {urNeighbour = labyrinthe[xCoord+1][yCoord-1];}
//			else {urNeighbour = labyrinthe[xCoord][yCoord-1];}
//			if(!urNeighbour.isWall() && urNeighbour != null) {
//				boxNeighbours.add(urNeighbour);
//			}
//		}
//		
//		if(yCoord != longueurMaze-1 && (yCoord %2==0 && xCoord != largeurMaze-1) ) {
//			MazeBox drNeighbour;
//			if(yCoord%2!=0) { drNeighbour = labyrinthe[xCoord+1][yCoord+1];}
//			else {drNeighbour = labyrinthe[xCoord][yCoord+1];}
//			if(!drNeighbour.isWall() && drNeighbour != null) {
//				boxNeighbours.add(drNeighbour);
//			}
//		}
		
		//Left Neighbour
		if(yCoord != 0) {
			MazeBox lNeighbour = labyrinthe[xCoord][yCoord-1];
			if(!lNeighbour.isWall() && lNeighbour != null) {
				boxNeighbours.add(lNeighbour);
			}
		}
		
		//Right Neighbour
		if(yCoord != largeurMaze-1) {
			MazeBox rNeighbour = labyrinthe[xCoord][yCoord+1];
			if(!rNeighbour.isWall() && rNeighbour != null) {
				boxNeighbours.add(rNeighbour);
			}
		}
		
		//Upright Neighbour
		MazeBox urNeighbour = null;
		if(xCoord%2==0) { //row pair			
			if(xCoord>0) {
				urNeighbour = labyrinthe[xCoord-1][yCoord];
			}
		}
		else if(xCoord%2!=0) {//row impair
			if(yCoord<largeurMaze-1) {
				urNeighbour = labyrinthe[xCoord-1][yCoord+1];
			}
		}
		if(urNeighbour != null && !urNeighbour.isWall()) {
			boxNeighbours.add(urNeighbour);
		}
		

		//Upleft Neighbour
		MazeBox ulNeighbour = null;
		if(xCoord%2==0) { //row pair			
			if(xCoord>0 && yCoord>0) {
				ulNeighbour = labyrinthe[xCoord-1][yCoord-1];
			}
		}		
		else if(xCoord%2!=0) {//row impair
			ulNeighbour = labyrinthe[xCoord-1][yCoord];			
		}
		if( ulNeighbour != null && !ulNeighbour.isWall()) {
			boxNeighbours.add(ulNeighbour);
		}
		
		
		//DownRight Neighbour
		MazeBox drNeighbour = null;
		if(xCoord%2==0) {//row pair
			if(xCoord <longueurMaze-1) {
				drNeighbour = labyrinthe[xCoord+1][yCoord];
			}
		}
		else if(xCoord%2!=0) {//row impair
			if(xCoord<longueurMaze-1 && yCoord <largeurMaze-1) {
				drNeighbour = labyrinthe[xCoord+1][yCoord+1];
			}
		}
		if( drNeighbour != null && !drNeighbour.isWall()) {
			boxNeighbours.add(drNeighbour);
		}

		//DownLeft Neighbour
		MazeBox dlNeighbour = null;
		if(xCoord%2==0) {//row pair
			if(xCoord <longueurMaze-1 && yCoord >0) {
				dlNeighbour = labyrinthe[xCoord+1][yCoord-1];
			}
		}
		else if(xCoord%2!=0) {//row impair
			if(xCoord<longueurMaze-1) {
				dlNeighbour = labyrinthe[xCoord+1][yCoord];
			}
		}
		if(dlNeighbour != null && !dlNeighbour.isWall() ) {
			boxNeighbours.add(dlNeighbour);
		}
		
		return boxNeighbours;	
	}

	//To get a list of all vertexes in graph by returning a list all vertexes in labyrinthe
	public List<Vertex> getAllVertexes() {
		List<Vertex> listAllVertex = new ArrayList<Vertex>();
		for (int i = 0; i<longueurMaze; i++) {
			for(int j=0; j<largeurMaze; j++) {
				listAllVertex.add(labyrinthe[i][j]);
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
			MazeBox[][] newLabyrinthe = new MazeBox[dimension[1]][dimension[0]];
			String line = br.readLine();
			int row = 0;			
			while(row<dimension[1]) { 
				int col = 0;
				while(col<dimension[0]) {
					if(line.charAt(col)=='D') {
						newLabyrinthe[row][col] = new DepartureBox (row,col,this);
						this.startBox = newLabyrinthe[row][col];
					}
					else if(line.charAt(col)=='E') {
						newLabyrinthe[row][col] = new EmptyBox(row,col,this);
					}
					else if(line.charAt(col)=='A') {
						newLabyrinthe[row][col] = new ArrivalBox(row,col,this);
						this.endBox = newLabyrinthe[row][col];
					}
					else if(line.charAt(col)=='W'){
						newLabyrinthe[row][col] = new WallBox(row,col,this);
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

	public void showShortestPath() {
		ShortestPaths shortestPath = new ShortestPathsImpl();
		ProcessedVertexes processedVertexes = new ProcessedVertexesImpl();
		MinDistance minDistance = new MinDistanceImpl();
		shortestPath = Dijkstra.dijkstra(this,startBox,endBox,processedVertexes,minDistance,shortestPath );	
		ArrayList<Vertex> resVertex = (ArrayList<Vertex>) shortestPath.getShortestPath(endBox);

		for(int i=0; i<this.longueurMaze; i++) {
			for(int j=0; j<this.largeurMaze; j++) {
				if(resVertex.contains(labyrinthe[i][j]) && labyrinthe[i][j]!=startBox && labyrinthe[i][j]!=endBox ) {
					//System.out.println(labyrinthe[i][j].getLabel());
					labyrinthe[i][j].setPath(true);
				}
			}
		}
		modified=true;
		stateChanged();
	}


}
