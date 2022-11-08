package graph;

public interface Graph {
	
	//To get quantity of vertex in a graph
	public int getNumberVertex();
	
	//To get quantity of arcs/aretes in a graph
	public int getNumberArc();
	
	//To get a vertex from graph with indice
	public Vertex getVertex(int indice);
}
