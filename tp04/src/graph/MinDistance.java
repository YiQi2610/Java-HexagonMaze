package graph;

public interface MinDistance {
	
	//To get the minimum distance of a vertex
	public double getminDistance(Vertex vertex);
	
	//To modify the minimum distance of a vertex
	public void setMinDist (Vertex vertex, double minDist);
	
	//To return vertex not yet processed which its minDistance is minimum
	public Vertex getNextVertex ();

}
