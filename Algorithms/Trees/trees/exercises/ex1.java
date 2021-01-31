package trees.exercises;
import tree.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ex1 {

	public static class DGraph<T> extends Graph{
		
		/**
		 * Returns true whether is a route between two nodes in a directed 
		 * graph. False otherwise
		 * 
		 * @param T start
		 * @param T dest
		 * @return boolean 
		 * */
		public boolean thereIsARoute(T start, T dest) {
			Queue<T> queue = new LinkedList<T>();
			T key = start;
			boolean[] visited = new boolean[this.getSize()];
			queue.add(start);
			Map<T, List<T>> adyList = this.getAdyacenceList();
			if(!adyList.containsKey(start))
				return false;
			
			while(!queue.isEmpty()) {
				List<T> edges = adyList.get(key);
				if(edges != null) {
					for(T e: edges) {
						if((int) e < this.getSize())
							visited[(int) e] = true;
						queue.add(e);
					}
				}
				key = queue.poll();
				if(key.equals(dest))
					return true;
			}
			return false;
		}
	}
	
	
}
