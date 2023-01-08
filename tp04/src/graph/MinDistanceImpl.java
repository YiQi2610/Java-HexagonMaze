package graph;

import java.util.HashMap;
import java.util.Map;

public class MinDistanceImpl implements MinDistance{

	Map<Vertex, Integer> minDistance = new HashMap<Vertex, Integer>();

	public int getminDistance(Vertex vertex) {
		return minDistance.get(vertex);
	}

	public void setMinDist(Vertex vertex, int minDist) {
		minDistance.put(vertex, minDist);
	}

}
