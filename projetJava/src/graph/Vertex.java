package graph;

public interface Vertex {
	
	//To get a vertex not yet processed which its distance is minimum
	public Vertex getVertexNotProcessed ();
	
	//To get the previous vertex of a vertex
	public Vertex getPrevVertex();
	
	//To get a list of successors vertex
	public Vertex[] getSuccesors();
	
	public String getLabel() ;

	
}
