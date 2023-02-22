package graph;

import java.util.HashMap;
import java.util.Map;

public class MinDistanceImpl extends HashMap<Vertex, Integer> implements MinDistance{
	
	public MinDistanceImpl() {
		super();
	}
	
	/**
	 * To get the minimum distance to reach a vertex
	 * @param vertex
	 * @return minimum distance
	 */
	public int getminDistance(Vertex vertex) {
		return get(vertex);
	}
	
	/**
	 * To add a pair of (vertex, minimum distance) into HashMap MinDistance
	 * @param vertex
	 * @param minimum distance to reach the vertex
	 */
	public void setMinDist(Vertex vertex, int minDist) {
		put(vertex, minDist);
	}

}
