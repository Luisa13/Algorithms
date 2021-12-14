package graphs.exercises.union;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 * 
 * APPROACH
 * The approach here is pretty simple.
 * There are different graphs and we don't know a priori how many of them are. So 
 * we just iterate the graph (first, build it) and every time we arrive to a dead
 * end, we take another node to start traversing. Obviously, tracking the visited 
 * nodes to don't count them twice...
 * 
 * @author luisa
 * 
 */
public class Provinces {

	public static int findCircleNum(int[][] isConnected) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] visited = new int[isConnected.length];
		int index = 0;

		// Build a graph
		for (int adj[] : isConnected) {
			List<Integer> adjList = new ArrayList<>();
			for (int i = 0; i < adj.length; i++) {
				if (adj[i] > 0)
					adjList.add(i);
			}
			map.put(index, adjList);
			visited[index] = adjList.size();
			index++;
		}

		int count = 0;
		// Visit all the groups
		for (int nexNode = 0; nexNode < visited.length; nexNode++) {
			if (visited[nexNode] > 0) {
				stack.push(nexNode);

				// Traverse an graph
				while (!stack.isEmpty()) {
					int current = stack.pop();
					if (visited[current] > 0) {
						visited[current]--;

						for (int child : map.get(current))
							stack.push(child);

					}
				}
				count++;
			}
		}

		return count;

	}

	public static void main(String[] args) {
		int [][] arr = {{1,1,0},{1,1,0},{0,0,1}};
		int nGroups = findCircleNum(arr);

	}

}
