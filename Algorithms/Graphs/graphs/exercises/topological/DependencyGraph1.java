package graphs.exercises.topological;

import java.util.*;


/**
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * EXAMPLE: Input: numCourses = 2, prerequisites = [[A,B],[B,A]] Output: false
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible
 * 
 * This exercises is based on Khan algorithm for a directed acyclic graph (DAG)
 * where the graph vertexes are printed in topological order. It puts in
 * practice the topological order and normally it is solved with a queue, but in
 * this case a stack is used.
 * 
 * 
 * @author luisa
 */
public class DependencyGraph1 {
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> projects = new HashMap<>();
        int[] inDegree = new int[numCourses];
        
        // Set up for topological order:
        // 1. Counter of the number dependencies
        // 2. Graph representation
        for(int i = 0; i<prerequisites.length; i++){
            int project = prerequisites[i][0];
            int dependecy = prerequisites[i][1];
            // Adding the dependency to the counter
            inDegree[project] ++;
            
            // Adding the project to the graph
            List<Integer> dependencies = new ArrayList<Integer>();
            if(projects.containsKey(project))
                dependencies = projects.get(project);
            dependencies.add(dependecy);
       
            projects.put(project, dependencies);
        }


        Set<Integer> notReady = new HashSet<>(); // Useful to keep the track of the projects aready done
        Stack<Integer> stack = new Stack<>(); // Useful to store them up and process them later
        
        for(Map.Entry<Integer, List<Integer>> entry : projects.entrySet()){
            if(inDegree[entry.getKey()] >= 0){
                stack.push(entry.getKey());
                notReady.add(entry.getKey());
            }
            
            while(!stack.isEmpty()){
                Integer currentProject = stack.peek();
                if(inDegree[currentProject] > 0){
                    for(Integer dependency: projects.get(currentProject)){

                        if(inDegree[dependency] >=0){// if it's not done
                            stack.push(dependency);
                            if(! notReady.add(dependency))
                                return false;
                            
                            break;
                        } 
                        inDegree[currentProject] --;
                        
                    }
                }
                else{
                    stack.pop();
                    notReady.remove(currentProject);
                    inDegree[currentProject] = -1;
                }
            }
        }
                
        return true;  
    }

	public static void main(String[] args) {
		int[][] coursesSchedule = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}}; 
		System.out.println(canFinish(7, coursesSchedule));
	}

}
