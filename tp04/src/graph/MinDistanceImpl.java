package graph;

import java.util.HashMap;
import java.util.Map;

public class MinDistanceImpl extends HashMap<Vertex, Integer> implements MinDistance{

	//Map<Vertex, Integer> minDistance = new HashMap<Vertex, Integer>();
	
	public MinDistanceImpl() {
		super();
	}
	
	public int getminDistance(Vertex vertex) {
		return get(vertex);
	}

	public void setMinDist(Vertex vertex, int minDist) {
		put(vertex, minDist);
	}

}
