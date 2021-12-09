package graphs.exercises.union;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * You are given a graph that started as a tree with n nodes labeled from 1 to
 * n, with one additional edge added. The added edge has two different vertices
 * chosen from 1 to n, and was not an edge that already existed. The graph is
 * represented as an array edges of length n where edges[i] = [ai, bi] indicates
 * that there is an edge between nodes ai and bi in the graph.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of n
 * nodes. If there are multiple answers, return the answer that occurs last in
 * the input.
 * 
 * APPROACH: 
 * 
 * 1) Traverse the graph to check if the two vertexes of the edge are
 * connected. 
 * 
 * 2) Given the fact that you are checking the connection of u, v
 * from an actual edge, it's important to avoid taking into account that very
 * edge. 
 * 
 * 3) Therefore, a possible solution would be to building the graph WHILE
 * traversing the array of edges
 * 
 * @author luisa
 */
public class RedundantConnections {

	public static int[] findRedundantConnection(int[][] edges) {
		List<Integer>[] graph = new ArrayList[edges.length + 1];
		List<int[]> redundant = new ArrayList<>();

		for (int i = 0; i <= edges.length; i++)
			graph[i] = new ArrayList<Integer>();

		for (int[] edge : edges) {
			if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge)) {
				redundant.add(edge);
			}
			// Build the graph
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		if (redundant.isEmpty())
			return new int[2];

		return redundant.get(redundant.size() - 1);
	}

	public static boolean dfs(List<Integer>[] graph, int[] edge) {
		Set<Integer> visited = new HashSet<>();
		int source = edge[0];
		int target = edge[1];

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		if (source == target)
			return true;

		while (!stack.isEmpty()) {
			int current = stack.pop();
			if (!visited.contains(current)) {
				visited.add(current);
				for (int node : graph[current]) {
					if (node == target)
						return true;

					stack.add(node);
				}
			}

		}
		return false;

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2 }, { 2, 3 }, { 1, 5 }, { 3, 4 }, { 1, 4 } };
		int[] edge = findRedundantConnection(arr);

	}

}
