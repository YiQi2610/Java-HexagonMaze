package graph;

public interface MinDistance {
	
	/**
	 * To get the minimum distance to reach a vertex
	 * @param vertex
	 * @return minimum distance
	 */
	public int getminDistance(Vertex vertex);
	
	/**
	 * To add a pair of (vertex, minimum distance) into HashMap MinDistance
	 * @param vertex
	 * @param minimum distance to reach the vertex
	 */
	public void setMinDist (Vertex vertex, int minDist);
	

}
