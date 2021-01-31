package trees.test;
import trees.exercises.ex1.DGraph;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ex1 {
	
	public DGraph<Integer> fillGraph() {
		DGraph graph = new DGraph<Integer>();
		graph.addEdge(1, 2);
		graph.addEdge(1, 0);
		graph.addEdge(0, 3);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		
		return graph;
	}
	
	@Test
	void thereIsARoute() {
		DGraph graph = fillGraph();
		assertTrue(graph.thereIsARoute(0, 4) == true);
	}
	
	@Test
	void thereIsNoRoute() {
		DGraph graph = fillGraph();
		assertTrue(graph.thereIsARoute(0, 2) != true);
	}
	
	@Test
	void thereIsARoute2() {
		DGraph graph = fillGraph();
		assertTrue(graph.thereIsARoute(1, 4) == true);
	}

}
