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

	private int largeurMaze; // number of columns in labyrinth
	private int longueurMaze; // number of rows in labyrinth
	private MazeBox[][] labyrinthe; // 2D labyrinth which contains all mazeboxes
	private MazeBox startBox; // departure maze box
	private MazeBox endBox; // arrival maze box
	private boolean modified =  false;// To know if the labyrinth has been modifies, false by default
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>(); // listeners that observe this maze model
	private Color wallBoxColor; // Color of wall box
	private Color arrBoxColor; // Color of arrival box
	private Color depBoxColor; // Color of departure box
	private Color emptyBoxColor; // Color of empty box
	private Color pathBoxColor; // Color of path box
	private int radiusHexgon; // radis of hexagon in labyrinth
	private char selectedTypeHexagon; // option chose when modifying type of mazebox (ex: if want to change any box into a wall box, the value is 'W')

	//Constructor
	public Maze() {
		super();
		this.largeurMaze = 10; //labyrinth created by default after running the program has 10 columns
		this.longueurMaze = 10; //labyrinth created by default after running the program has 10 rows
		//Default colors for all type of mazebox
		this.emptyBoxColor = Color.LIGHT_GRAY;
		this.wallBoxColor = Color.DARK_GRAY;
		this.depBoxColor = Color.RED;
		this.arrBoxColor = Color.BLUE;
		this.pathBoxColor = Color.GREEN;
		//By default, all mazebox is empty box
		this.labyrinthe = new MazeBox[longueurMaze][largeurMaze];
		for(int row = 0; row<longueurMaze ; row++) {
			for(int col = 0; col<largeurMaze; col++) {
				labyrinthe[row][col] = new EmptyBox(row, col);
			}
		}
	}
	
	/**
	 * To inform all listeners/observers when labyrinth is modified, to make sure that view is updated after every changes
	 */
	public void stateChanged() {
		ChangeEvent evt = new ChangeEvent(this);
		for(ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}
	
	/**
	 * Add listener that observe this maze model
	 * @param listener
	 */
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Return true if labyrinth is modified with all setters
	 * @return 
	 */
	public boolean isModified() {
		return modified;
	}
	
	/**
	 * Get number of columns in labyrinth
	 * @return
	 */
	public int getLargeurMaze() {
		return largeurMaze;
	}

	/**
	 * Get number of rows in labyrinth
	 * @return
	 */
	public int getLongueurMaze() {
		return longueurMaze;
	}

	/**
	 * Get departure box in labyrinth
	 * @return
	 */
	public MazeBox getStartBox() {
		return startBox;
	}
	
	/**
	 * Get arrival box in labyrinth
	 * @return
	 */
	public MazeBox getEndBox() {
		return endBox;
	}
	
	/**
	 * Get radius of each hexagon in labyrinth
	 * @return
	 */
	public int getRadiusHexagon() {
		return radiusHexgon;
	}
	
	/**
	 * Get all mazeboxes in labyrinth
	 * @return
	 */
	public MazeBox[][] getLabyrinthe() {
		return labyrinthe;
	}
	
	/**
	 * Get colour for all types of maze boxes
	 * @return
	 */
	public Color getWallBoxColor() {return wallBoxColor;}

	public Color getArrBoxColor() {return arrBoxColor;}

	public Color getDepBoxColor() {return depBoxColor;}

	public Color getEmptyBoxColor() {return emptyBoxColor;}
	
	public Color getPathBoxColor() {return pathBoxColor;}
	
	/**
	 * To know which modify option is chosen in selection panel
	 * When user clicks on a mazebox, change the type of this mazebox based on option
	 * @return
	 */
	public char getSelectedTypeHexagon() {return selectedTypeHexagon;}
	
	/**
	 * To set which option is selected
	 * @param selectedTypeHexagon
	 */
	public void setSelectedTypeHexagon(char selectedTypeHexagon) {
		this.selectedTypeHexagon = selectedTypeHexagon;
		modified = true ;
		stateChanged();
	}
	
	// Setters to change color of all types of boxes, every setters are follwed by setting true to attribute modified and call statechanged to inform listeners
	// I choose to set all these colors as attribute to maze model to reduce complexity while rechoosing colors in configuration menu
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
	
	// Setters to set departure box and arrival box
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

	//Setters to change the height and width of labyrinth when creating a new labyrinth
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
	
	// Change labyrinth when creating a new labyrinth
	public void setLabyrinthe(MazeBox[][] labyrinthe) {
		this.labyrinthe = labyrinthe;
		modified = true ; 
		stateChanged();
	}
	
	/**
	 * When a mazebox is clicked, changes its type based on the option chosen in modify panel
	 * @param row
	 * @param col
	 * @param type
	 */
	public void setTypeBox(int row, int col, char type) {
		if(type == 'E') { //If user wants to change it to empty box
			// If the mazebox clicked was a departure box or an arrival box, set start box and end box to null
			// To make sure that user can choose another departure box and arival box, as user can only set these two boxes when they are not null
			if(this.labyrinthe[row][col].isDeparture()) { 
				this.startBox = null;
			}
			else if(this.labyrinthe[row][col].isArrival()) {
				this.endBox = null;
			}
			//Create a new empty box with respective row and column
			this.labyrinthe[row][col] = new EmptyBox(row,col);

		}
		else if(type == 'W') { //if user wants to change it a wall box
			//Same steps as above
			if(this.labyrinthe[row][col].isDeparture()) {
				this.startBox = null;
			}
			else if(this.labyrinthe[row][col].isArrival()) {
				this.endBox = null;
			}
			this.labyrinthe[row][col] = new WallBox(row,col);
		}
		else if(type == 'D') { //if user wants to change it to a departure box
			//verify if it was an arrival box, if yes, set endbox to null
			if(this.labyrinthe[row][col].isArrival()) {
				this.endBox = null;
			}
			//Create a new Departure box and set startbox
			this.labyrinthe[row][col] = new DepartureBox(row,col);
			setStartBox(labyrinthe[row][col]);
		}
		if(type == 'A') { //if user wants to change it to an arrival box
			//Same steps as above, verify if it was a departure box
			if(this.labyrinthe[row][col].isDeparture()) {
				this.startBox = null;
			}
			// Create a new arrival box and set end box
			this.labyrinthe[row][col] = new ArrivalBox(row,col);
			setEndBox(labyrinthe[row][col]);
		}
		//Set modified to true and call stateChanged to inform listeners to adapt their view
		modified = true ; 
		stateChanged();
	}
	
	/**
	 * Draw a hexagon labyrinth on maze panel, redraw from time to time when there are modification in labyrinth
	 * @param graphics
	 * @param d (dimension of mazePanel)
	 */
	public void createHexagonMaze(Graphics graphics, Dimension d){
		int radius = 0;
		Color color = null;
		int sizePane = (int) (d.getWidth()-(d.getWidth()*0.2));
		//Find radius by using width or height whic has a greater value
		//To make sure that the labyrinth will not exceed the panel
		if(largeurMaze>=longueurMaze) {
			radius = (int) (sizePane/(largeurMaze*2));
		}
		else {
			radius = (int) (sizePane/(longueurMaze*2));
		}
		this.radiusHexgon = radius;
		//For every hexagon, calculate its center coordinates
		for(int row=0; row<longueurMaze; row++) {
			for(int col=0; col<largeurMaze; col++) {	
				int cx = (int)(col*radius*1.5+radius);
				int cy = (int)(int)((row*0.75*radius*Math.sqrt(3)+radius*Math.sqrt(3)/2));
				if(row % 2 != 0) {//if the row is odd, we add 0.75*radius as it's moved to the right
					cx += (0.75*radius);
				}
				//Check the function of the mazebox and set its color
				if(labyrinthe[row][col].isEmpty() && !labyrinthe[row][col].isPath()) {color = getEmptyBoxColor();}
				if (labyrinthe[row][col].isEmpty() && labyrinthe[row][col].isPath()) {color = getPathBoxColor();}
				if (labyrinthe[row][col].isWall()) {color = getWallBoxColor();}
				if (labyrinthe[row][col].isArrival()) {color = getArrBoxColor();}
				if (labyrinthe[row][col].isDeparture()) {color = getDepBoxColor();}
				//tell mazebox class to draw hexagon by giving hime its center, radius and color
				this.labyrinthe[row][col].paint(graphics,radius,new Point(cx,cy),color);
			}
		}

	}

	/**
	 * To get a list of neighbouring vertices of a vertice in graph, used in Dijsktra to add elements in ShortestPaths
	 * In our hexagon maze, every maze box has 6 neighbouring vertices, every neighbors will be added if it's not a wall box
	 * @param vertex
	 * @return list of neighbouring vertices
	 */
	public List<Vertex> getSuccessors(Vertex vertex) {
		// Create an ArrayList to hold the neighboring vertices
		List <Vertex> boxNeighbours = new ArrayList <Vertex>();
		
		// Get the x and y coordinates of the current vertex
		int row = ((MazeBox)vertex).getxBox();
		int col = ((MazeBox)vertex).getyBox();

		//Left Neighbour 
		if(col != 0) {
			MazeBox lNeighbour = labyrinthe[row][col-1];
			// If the left neighbor exists and is not a wall, add it to the list of neighbor
			if(!lNeighbour.isWall() && lNeighbour != null) {
				boxNeighbours.add(lNeighbour);
			}
		}
		
		//Right Neighbour
		if(col != largeurMaze-1) {
			MazeBox rNeighbour = labyrinthe[row][col+1];
			// If the right neighbor exists and is not a wall, add it to the list of neighbors
			if(!rNeighbour.isWall() && rNeighbour != null) {
				boxNeighbours.add(rNeighbour);
			}
		}
		
		//Upright Neighbour
		MazeBox urNeighbour = null;
		if(row%2==0) { //row is even			
			if(row>0) {//first even row don't have upright neighbor
				urNeighbour = labyrinthe[row-1][col];
			}
		}
		else if(row%2!=0) {//row is odd
			if(col<largeurMaze-1) {//cases of last column in odd row don't have upright neighbor
				urNeighbour = labyrinthe[row-1][col+1];
			}
		}
		// If the upper-right neighbor exists and is not a wall, add it to the list of neighbors
		if(urNeighbour != null && !urNeighbour.isWall()) {
			boxNeighbours.add(urNeighbour);
		}
		

		//Upleft Neighbour
		MazeBox ulNeighbour = null;
		if(row%2==0) { //row is even			
			if(row>0 && col>0) {//starting from second row and second colomn as first column and first row don't have upleft neighbor
				ulNeighbour = labyrinthe[row-1][col-1];
			}
		}		
		else if(row%2!=0) {//row is odd
			ulNeighbour = labyrinthe[row-1][col];//every case of odd row has upright neighbor			
		}
		// If the upper-left neighbor exists and is not a wall, add it to the list of neighbors
		if( ulNeighbour != null && !ulNeighbour.isWall()) {
			boxNeighbours.add(ulNeighbour);
		}
		
		
		//DownRight Neighbour
		MazeBox drNeighbour = null;
		if(row%2==0) {//row is even
			if(row <longueurMaze-1) {//last row don;t have downright neigbor
				drNeighbour = labyrinthe[row+1][col];
			}
		}
		else if(row%2!=0) {//row is odd
			if(row<longueurMaze-1 && col <largeurMaze-1) {//for cases in last row and last column don't have downright neigbor
				drNeighbour = labyrinthe[row+1][col+1];
			}
		}
		// If the downright neighbor exists and is not a wall, add it to the list of neighbors
		if( drNeighbour != null && !drNeighbour.isWall()) {
			boxNeighbours.add(drNeighbour);
		}

		//DownLeft Neighbour
		MazeBox dlNeighbour = null;
		if(row%2==0) {//row is even
			if(row <longueurMaze-1 && col >0) {//last row and first column don't have downleft neigbor
				dlNeighbour = labyrinthe[row+1][col-1];
			}
		}
		else if(row%2!=0) {//row is odd
			if(row<longueurMaze-1) {//last row don't have downleft neighbor
				dlNeighbour = labyrinthe[row+1][col];
			}
		}
		// If the downleft neighbor exists and is not a wall, add it to the list of neighbors
		if(dlNeighbour != null && !dlNeighbour.isWall() ) {
			boxNeighbours.add(dlNeighbour);
		}
		
		return boxNeighbours;	
	}

	/**
	 * To get a list of all vertices in graph, used in Dijsktra to find next pivot
	 * @return a list of vertices
	 */
	public List<Vertex> getAllVertexes() {
		List<Vertex> listAllVertex = new ArrayList<Vertex>();
		//add one by one all maze boxes in labyrinth in a list of vertexes (Mazebox is a vertex)
		for (int i = 0; i<longueurMaze; i++) {
			for(int j=0; j<largeurMaze; j++) {
				listAllVertex.add(labyrinthe[i][j]);
			}
		}
		return listAllVertex;
	}

	/**
	 * To get the weight between two vertices, in our algorithm, weight between two vertices is always 1
	 * @param src
	 * @param dst
	 * @return weight
	 */
	public int getWeight(Vertex src, Vertex dst) {
		return 1;
	}	
	
	/**
	 * Import a maze text file to show labyrinth configured
	 * @param fileName
	 * @throws MazeReadingException
	 * @throws Exception
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException, Exception{
		//Reinitailize startbox and endbox as they may not be null if we use other labyrinth before
		this.startBox = null;
		this.endBox = null;
		try (
			//Use buffer reader to read file given in parameters
			BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
			
			//Find width and height of the labyrinth imported by using function findDemension
			//This is used to create labyrinth with the same dimension
			int[] dimension = new int[2];		
			dimension = findDimension(fileName);
			
			//Set its width and height
			setLargeurMaze(dimension[0]);
			setLongueurMaze(dimension[1]);
			
			//Initialise a new empty labyrinth with dimension found 
			MazeBox[][] newLabyrinthe = new MazeBox[dimension[1]][dimension[0]];
			
			String line = br.readLine();
			int row = 0;
			 
			while(row<dimension[1]) { //read line by line
				int col = 0;
				while(col<dimension[0]) {// read column by column
					if(line.charAt(col)=='D') {// when it reads a 'D', it create a Departure box with is row and column
						newLabyrinthe[row][col] = new DepartureBox (row,col);
						this.startBox = newLabyrinthe[row][col];//set a new startbox
					}
					else if(line.charAt(col)=='E') {// when it reads a 'E', it create an Empty box with is row and column
						newLabyrinthe[row][col] = new EmptyBox(row,col);
					}
					else if(line.charAt(col)=='A') {// when it reads a 'A', it create an Arrival box with is row and column
						newLabyrinthe[row][col] = new ArrivalBox(row,col);
						this.endBox = newLabyrinthe[row][col];//set a new end box
					}
					else if(line.charAt(col)=='W'){// when it reads a 'W', it create a Wall box with is row and column
						newLabyrinthe[row][col] = new WallBox(row,col);
					}
					else { //If none of these 4 caraceters in presented, a maze reading exception is thrown with message below
						throw new MazeReadingException(fileName,row+1,"Invalid label of Mazebox");
					}
					col++;
				}
				line = br.readLine();// read the next line and begin the loop
				row++;	
			}
			//The labyrinth has finished intializtion and all mazeboxes are created, set this new labyrinth into the real labyrinth
			this.setLabyrinthe(newLabyrinthe);
			br.close();
		}catch(FileNotFoundException e){// If the file don't exist, FileNotFoundException is thrown
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Save a labyrinth configured into a text file to be reused next time
	 * @param fileName
	 * @throws Exception
	 */
	public final void saveToTextFile(String fileName) throws Exception {
		//For each mazebox in labyrinth, use printwriter to write its label into file given in parameter
		//The file has the same number of rows and columns as the labyrinth
		try (PrintWriter pw = new PrintWriter("data/"+fileName)) {
			for(int i = 0; i<this.getLongueurMaze(); i++) {
				for(int j = 0; j<this.getLargeurMaze(); j++) {
					pw.print(this.labyrinthe[i][j].getName());
				}
				pw.print("\n");
			}
			pw.close();
		}
		//Set modified to false to avoid evoking message "Maze not saved" when we quit the program, as it show message when attribut modified is true
		modified = false;
	}
	
	/**
	 * Create a new empty labyrinth with width and height given in dimension panel
	 * @param widthGiven
	 * @param heightGiven
	 */
	public void setDimension(int widthGiven, int heightGiven) {
		//Initialize startbox and endbox with null and set new height and width
		setStartBox(null);
		setEndBox(null);
		this.setLargeurMaze(widthGiven);
		this.setLongueurMaze(heightGiven);

		MazeBox[][] newLabyrinthe = new MazeBox[heightGiven][widthGiven];
		for(int row = 0; row<heightGiven ; row++) {
			for(int col = 0; col<widthGiven; col++) {
				newLabyrinthe[row][col] = new EmptyBox(row, col);
			}
		}
		this.setLabyrinthe(newLabyrinthe);//update the labyrinth in maze class
	}
	
	/**
	 * Find number of rows and column in a text file containing labyrinth 
	 * @param fileName
	 * @return dimension
	 * @throws MazeReadingException
	 */
	public int[] findDimension(String fileName) throws MazeReadingException {
		int[] dimension = new int[2];
		dimension[0] = 0;
		dimension[1] = 1;
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {		
			String line = br.readLine();
			if(line == null) {//if the file is empty, a MazeReadingException is thrown
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
	
	/**
	 * Find the shortest path form start box to end box by using Dijsktra algorithm
	 * All mazeboxes which take part in the shortest path will have their attribut isPath = true
	 */
	public void showShortestPath() {
		clearPath(); //set all Mazeboxes with isPath=false as there maybe other shortestPath shown before
		ShortestPaths shortestPath = new ShortestPathsImpl();
		ProcessedVertexes processedVertexes = new ProcessedVertexesImpl();
		MinDistance minDistance = new MinDistanceImpl();
		//Launch dijkstra and get a list of vertexes consisting the shortest path
		shortestPath = Dijkstra.dijkstra(this,startBox,endBox,processedVertexes,minDistance,shortestPath );	
		//Find the vertices from start box to end box with getShortestPath by giving endBox
		ArrayList<Vertex> resVertex = (ArrayList<Vertex>) shortestPath.getShortestPath(endBox);
		//If there is no shortestpath found, set modified to false and quit the function so that the view can show a warning message
		if(!resVertex.contains(startBox)) {
			modified=false;
			return;
		}
		for(int i=0; i<this.longueurMaze; i++) {
			for(int j=0; j<this.largeurMaze; j++) {
				if(resVertex.contains(labyrinthe[i][j]) && labyrinthe[i][j]!=startBox && labyrinthe[i][j]!=endBox ) {// only setPath for vertices between startbox and endbox
					labyrinthe[i][j].setPath(true);
				}
			}
		}
		modified=true;
		stateChanged();
	}
	
	/**
	 * To set isPath of all mazeboxes to false to clear shortest path launched with Dijsktra
	 */
	public void clearPath() {
		for(int row = 0; row<longueurMaze ; row++) {
			for(int col = 0; col<largeurMaze; col++) {
				labyrinthe[row][col].setPath(false);
			}
		}
	}


}
