package graph;

import java.util.List;

public interface Graph {
	
	/**
	//To get quantity of vertex in a graph
	public int getNumberVertex();
	
	//To get quantity of arcs/aretes in a graph
	public int getNumberArc();
	
	//To get a vertex from graph with indice
	public Vertex getVertex(int indice);
	*/
	
	//To get a list of all vertexes in graph
	public List<Vertex> getAllVertexes() ;
	
	//To get a list of sucessors of a vertex in graph
	public List<Vertex> getSuccessors(Vertex vertex) ;
	
	//To get the weight between two vertexes
	public int getWeight(Vertex src,Vertex dst) ;

}
