package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represent an inteface of a directed graph. A Graph might be represented in many ways, 
 * for example with an adyacence matriz or adyacence list. In this case I will use the 
 * data structures provided by Java (Map in this case, in which each key is a vertex of 
 * the graph associated with a adyacence list), but it would be possible to use the data 
 * structures I implement in the other exercises.
 * 
 * @param T
 * @author luisa
 * */
public abstract class Graph<T> {

	private Map<T, List<T>> adyMap;
	private int size;
	
	/**
	 * Class constructor
	 * */
	public Graph(){
		 this.adyMap = new HashMap<>();
		 this.size = 0;
	}
	
	/**
	 * Add a new edge in the directed graph from the vertex v to the vertex w.
	 * 
	 * @param T Starting vertex
	 * @param T Destiny vertex
	 * */
	public void addEdge(T v, T w) {
		List<T> list = new ArrayList<T>();
		
		// If the vertex is already in the graph
		if(this.adyMap.containsKey(v))
			list = adyMap.get(v);
		else // Otherwise it is added
			this.size ++;
		
		list.add(w);
		this.adyMap.put(v, list);
		
	}
}
