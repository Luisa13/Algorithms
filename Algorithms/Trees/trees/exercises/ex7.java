package trees.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * 
 * */
public class ex7 {
	
	/**
	 * Pair class
	 * */
	public class Pair<T, R>{
		T first;
		R second;
		
		public Pair(T first, R second) {
			this.first = first;
			this.second = second;
		}
	}
	
	/**
	 * Returns the list of dependencies of a project referenced by a key updated with the new value.
	 * 
	 * @param Map <T, List<T>>
	 * @param key T
	 * @param value T
	 * 
	 * */
	private static <T> List<T> updatedDependencies(Map<T, List<T>> projects, T key, T value){
		List<T> dependencies = new ArrayList<T>();
		if( projects.containsKey(key) ){
			dependencies = projects.get(key); 
		}
		dependencies.add(value);
		return dependencies;
	}
	
	/**
	 * Returns true if the set contains all the dependencies provided in the list. 
	 * False otherwise
	 * 
	 * @param List<T> Dependency list
	 * @param Set<T>  Set that might contain the dependencies
	 * */
	private static <T> boolean containsAllDependencies(List<T> dependencies, Set<T> set) {
		if(dependencies == null)
			return true;
		
		for(T element: dependencies) {
			if(! set.contains(element))
				return false;
		}
		
		return true;
	}
	
	/**
	 * Given a list of projects and a list of dependencies, it returns a list of 
	 * projects sorted in a way that should be built.
	 * 
	 * @param List<T> 			Unsorted project list that should be created
	 * @param List<Pair<T,T>> 	List of dependencies where the the first element 
	 * 							is the project that depends of the second value.
	 * 
	 * @return Set<T> Project list sorted in the order that should be built
	 * 
	 * */
	public static <T> Set<T> buildOrder(List<T> projects, List<Pair<T,T>>dependencies){
		Map<T, List<T>> releasing = new HashMap<>();
		Map<T, List<T>> depMap = new HashMap<>();
		
		// Build a adjacency matrix
		for(Pair<T,T> dep: dependencies) {
			releasing.put(dep.first, updatedDependencies(releasing, dep.first, dep.second));
			depMap.put(dep.second, updatedDependencies(releasing, dep.second, dep.first));

		}
		
		// Add the missing projects in the map: The projects that does not have any dependency
		// Im using a LinkedHashSet because of the need to keep it sorted as inserting order
		Set<T> buildOrderList = new LinkedHashSet<>();
		Queue<T> queue = new LinkedList<>();
		for(T project: projects) {
			if( !depMap.containsKey(project)) {
				buildOrderList.add(project);
				queue.add(project);
			}
		}
		
		while( !queue.isEmpty() ) {
			T project = queue.peek();
			List<T> deps = depMap.get(project);
			
			// If contains all the needed dependencies then can be built
			if(containsAllDependencies(deps, buildOrderList)) {
				buildOrderList.add(project);
				queue.poll();
				// Once a project has been built, which other is released
				List<T> releases = releasing.get(project);
				if(releases != null) {
					for(T rel: releases) {
						if(!buildOrderList.contains(rel))
							queue.add(rel);
					}
				}
			}else {
				T next = queue.poll();
				queue.add(next);
			}
			
		}
		
		return buildOrderList;
		
	}
}
