package maze;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
	private char selectedTypeHexagon;


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
	
	public char getSelectedTypeHexagon() {return selectedTypeHexagon;}

	public void setSelectedTypeHexagon(char selectedTypeHexagon) {
		this.selectedTypeHexagon = selectedTypeHexagon;
		modified = true ;
		stateChanged();
	}

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
		if(type == 'E') { 
			if(this.labyrinthe[row][col].getName() == 'D') {
				this.startBox = null;
			}
			else if(this.labyrinthe[row][col].getName() == 'A') {
				this.endBox = null;
			}
			this.labyrinthe[row][col] = new EmptyBox(row,col,this);

		}
		else if(type == 'W') { 
			if(this.labyrinthe[row][col].getName() == 'D') {
				this.startBox = null;
			}
			else if(this.labyrinthe[row][col].getName() == 'A') {
				this.endBox = null;
			}
			this.labyrinthe[row][col] = new WallBox(row,col,this);
		}
		else if(type == 'D') { 
			if(this.labyrinthe[row][col].getName() == 'A') {
				this.endBox = null;
			}
			this.labyrinthe[row][col] = new DepartureBox(row,col,this);
			setStartBox(labyrinthe[row][col]);
		}
		if(type == 'A') { 
			if(this.labyrinthe[row][col].getName() == 'D') {
				this.startBox = null;
			}
			this.labyrinthe[row][col] = new ArrivalBox(row,col,this);
			setEndBox(labyrinthe[row][col]);
		}
		modified = true ; 
		stateChanged();
	}

	public void createHexagonMaze(Graphics graphics, Dimension d){
		int radius = 0;
		Color color = null;
		int sizePane = (int) (d.getWidth()-(d.getWidth()*0.2));
		if(largeurMaze>=longueurMaze) {
			radius = (int) (sizePane/(largeurMaze*2));
		}
		else {
			radius = (int) (sizePane/(longueurMaze*2));
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

		int row = ((MazeBox)vertex).getxBox();
		int col = ((MazeBox)vertex).getyBox();
		Maze refLabyrinthe = ((MazeBox)vertex).getRefLabyrinthe();

		//Left Neighbour
		if(col != 0) {
			MazeBox lNeighbour = labyrinthe[row][col-1];
			if(!lNeighbour.isWall() && lNeighbour != null) {
				boxNeighbours.add(lNeighbour);
			}
		}
		
		//Right Neighbour
		if(col != largeurMaze-1) {
			MazeBox rNeighbour = labyrinthe[row][col+1];
			if(!rNeighbour.isWall() && rNeighbour != null) {
				boxNeighbours.add(rNeighbour);
			}
		}
		
		//Upright Neighbour
		MazeBox urNeighbour = null;
		if(row%2==0) { //row pair			
			if(row>0) {
				urNeighbour = labyrinthe[row-1][col];
			}
		}
		else if(row%2!=0) {//row impair
			if(col<largeurMaze-1) {
				urNeighbour = labyrinthe[row-1][col+1];
			}
		}
		if(urNeighbour != null && !urNeighbour.isWall()) {
			boxNeighbours.add(urNeighbour);
		}
		

		//Upleft Neighbour
		MazeBox ulNeighbour = null;
		if(row%2==0) { //row pair			
			if(row>0 && col>0) {
				ulNeighbour = labyrinthe[row-1][col-1];
			}
		}		
		else if(row%2!=0) {//row impair
			ulNeighbour = labyrinthe[row-1][col];			
		}
		if( ulNeighbour != null && !ulNeighbour.isWall()) {
			boxNeighbours.add(ulNeighbour);
		}
		
		
		//DownRight Neighbour
		MazeBox drNeighbour = null;
		if(row%2==0) {//row pair
			if(row <longueurMaze-1) {
				drNeighbour = labyrinthe[row+1][col];
			}
		}
		else if(row%2!=0) {//row impair
			if(row<longueurMaze-1 && col <largeurMaze-1) {
				drNeighbour = labyrinthe[row+1][col+1];
			}
		}
		if( drNeighbour != null && !drNeighbour.isWall()) {
			boxNeighbours.add(drNeighbour);
		}

		//DownLeft Neighbour
		MazeBox dlNeighbour = null;
		if(row%2==0) {//row pair
			if(row <longueurMaze-1 && col >0) {
				dlNeighbour = labyrinthe[row+1][col-1];
			}
		}
		else if(row%2!=0) {//row impair
			if(row<longueurMaze-1) {
				dlNeighbour = labyrinthe[row+1][col];
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

	//To get the weight between two vertexes
	public int getWeight(Vertex src, Vertex dst) {
		return 1;
	}	

	public final void initFromTextFile(String fileName) throws MazeReadingException, Exception{
		this.startBox = null;
		this.endBox = null;
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
		modified = false;
	}

	public void setDimension(int widthGiven, int heightGiven) {
		setStartBox(null);
		setEndBox(null);
		this.setLargeurMaze(widthGiven);
		this.setLongueurMaze(heightGiven);

		MazeBox[][] newLabyrinthe = new MazeBox[heightGiven][widthGiven];
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

	public void showShortestPath() {
		clearPath();
		ShortestPaths shortestPath = new ShortestPathsImpl();
		ProcessedVertexes processedVertexes = new ProcessedVertexesImpl();
		MinDistance minDistance = new MinDistanceImpl();
		shortestPath = Dijkstra.dijkstra(this,startBox,endBox,processedVertexes,minDistance,shortestPath );	
		ArrayList<Vertex> resVertex = (ArrayList<Vertex>) shortestPath.getShortestPath(endBox);
		if(!resVertex.contains(startBox)) {
			modified=false;
			return;
		}
		for(int i=0; i<this.longueurMaze; i++) {
			for(int j=0; j<this.largeurMaze; j++) {
				if(resVertex.contains(labyrinthe[i][j]) && labyrinthe[i][j]!=startBox && labyrinthe[i][j]!=endBox ) {
					labyrinthe[i][j].setPath(true);
				}
			}
		}
		modified=true;
		stateChanged();
	}
	
	public void clearPath() {
		for(int row = 0; row<longueurMaze ; row++) {
			for(int col = 0; col<largeurMaze; col++) {
				labyrinthe[row][col].setPath(false);
			}
		}
	}


}