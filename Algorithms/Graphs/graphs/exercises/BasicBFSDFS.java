package graphs.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Traverse a graph in BFS and DFS way.
 * 
 * @author luisa
 */
public class BasicBFSDFS {

	public static class Graph<T> {
		private Map<T, List<T>> adjMatrix;

		public Graph() {
			this.adjMatrix = new HashMap<T, List<T>>();
		}

		/**
		 * Add a new edge with its corresponding vertexes
		 * 
		 * @param T
		 * @param List<T>
		 * 
		 */
		public void addEdge(T node, T... vertexes) {
			List<T> adj = new ArrayList<T>();
			if (adjMatrix.containsKey(node))
				adj = adjMatrix.get(node);

			for (T v : vertexes)
				adj.add(v);

			this.adjMatrix.put(node, adj);
		}

		/**
		 * Get the number of nodes
		 * 
		 */
		public int getNumNodes() {
			return this.adjMatrix.size();
		}

		/**
		 * Print all the nodes after traversing them as DFS, starting from the specified
		 * node in the parameter
		 * 
		 * @param T
		 */
		public void DFS(T node) {
			if (!this.adjMatrix.containsKey(node))
				return;

			Stack<T> stack = new Stack<>();
			Set<T> visited = new HashSet<>();

			stack.push(node);
			while (!stack.isEmpty()) {
				T current = stack.pop();
				if (!visited.contains(current)) {
					System.out.print(current + ", ");

					visited.add(current);
					if (this.adjMatrix.containsKey(current)) {
						List<T> children = this.adjMatrix.get(current);

						for (T child : children)
							stack.push(child);
					}
				}
			}
		}

		/**
		 * Print all the nodes after traversing them as BFS, starting from the specified
		 * node in the parameter
		 * 
		 * @param T
		 */
		public void BFS(T node) {
			if (!this.adjMatrix.containsKey(node))
				return;
			Queue<T> queue = new LinkedList<T>();
			Set<T> visited = new HashSet<>();

			queue.add(node);
			while (!queue.isEmpty()) {
				T current = queue.poll();
				
				if (!visited.contains(current)) {
					System.out.print(current + ", ");
					visited.add(current);
					if (this.adjMatrix.containsKey(current)) {
						List<T> children = this.adjMatrix.get(current);
						for (T child : children)
							queue.add(child);
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>();
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 0, 1, 5);
		
		System.out.println("Traversing in DFS...");
		graph.DFS(0);
		
		System.out.println("\nTraversing in BFS...");
		graph.BFS(0);
	}
}
