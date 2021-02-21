package trees.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class ex7 {
	
	public class Pair<T, R>{
		T first;
		R second;
		
		public Pair(T first, R second) {
			this.first = first;
			this.second = second;
		}
	}
	
	/**
	 * Given a map and a pair of values, where the first element refers to the 
	 * key and the second value to the value in a list, updated the corresponding 
	 * list with the new value and returns it.
	 * 
	 * @param Map <T, List<T>>
	 * @param key T
	 * @param value T
	 * 
	 * */
	private static <T> List<T> updatedDependencies(Map<T, List<T>> map, T key, T value){
		List<T> list = new ArrayList<T>();
		if( map.containsKey(key) ){
			list = map.get(key); 
		}
		list.add(value);
		return list;
	}
	
	private static <T> boolean containsAllDependencies(List<T> list, Set<T> set) {
		
	}
	
	/**
	 * Given a list of projects and a list of dependencies, which consists in a pair of values 
	 * where the first elemenet is the project that depends of the other one, it retunrs a list 
	 * of projects sorted in a way that might be build
	 * */
	public static <T> Set<T> buildOrder(List<T> projects, List<Pair<T,T>>dependencies){
		Map<T, List<T>> releasing = new HashMap<>();
		Map<T, List<T>> depMap = new HashMap<>();
		
		// Build a matrix of adyacence
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
			
			// If contains all the needed dependencies if ca be build 
			if(containsAllDependencies(deps, buildOrderList)) {
				buildOrderList.add(project);
				List<T> releases = releasing.get(project);
				for(T rel: releases) {
					queue.add(rel);
				}
			}else {
				T next = queue.poll();
				queue.add(next);
			}
			
		}
		
		return buildOrderList;
		
	}
}
