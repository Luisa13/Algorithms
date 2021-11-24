package graphs.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphs.exercises.DependencyGraph1;

class DependencyGraph1_Test {

	@Test
	void AcycledGraph_True_Test() {
		int[][] coursesSchedule = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}; 
		assertTrue(DependencyGraph1.canFinish(7, coursesSchedule));
	}
	
	@Test
	void CycledGraph_False_Test() {
		int[][] coursesSchedule = {{1,0},{0,2},{2,1}}; 
		assertFalse(DependencyGraph1.canFinish(3, coursesSchedule));
	}
	
	@Test
	void CycledGraphWithPossibleProjects_False_Test() {
		int[][] coursesSchedule = {{4,3},{3,1},{1,0},{0,2},{2,1}}; 
		assertFalse(DependencyGraph1.canFinish(5, coursesSchedule));
	}
	
	@Test
	void TwoDependenciesForOneCourse_True_Test() {
		int[][] coursesSchedule = {{2,0},{2,1},{1,3}}; 
		assertTrue(DependencyGraph1.canFinish(4, coursesSchedule));
	}
	
	@Test
	void TwoCoursesWithSameDependency_True_Test() {
		int[][] coursesSchedule = {{2,1},{0,1},{3,0}}; 
		assertTrue(DependencyGraph1.canFinish(4, coursesSchedule));
	}


}
