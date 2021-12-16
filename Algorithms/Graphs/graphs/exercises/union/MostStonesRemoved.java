package graphs.exercises.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * On a 2D plane, we place n stones at some integer coordinate points. Each
 * coordinate point may have at most one stone.
 * 
 * A stone can be removed if it shares either the same row or the same column as
 * another stone that has not been removed.
 * 
 * Given an array stones of length n where stones[i] = [xi, yi] represents the
 * location of the ith stone, return the largest possible number of stones that
 * can be removed.
 * 
 * WATCH OUT
 * Rows must match rows and columns columns.
 * 
 * @author luisa
 */
public class MostStonesRemoved {
	private static final boolean ROWS = false;
	private static final boolean COLS = true;
	
	private static  Map<Integer, List<Integer>> graphRows = new HashMap<>();
	private static  Map<Integer, List<Integer>> graphCols = new HashMap<>();
    private static Set<List<Integer>> taken;
    
    public static int removeStones(int[][] stones) {
    	taken = new HashSet<>();
    	graphRows = createGraph(stones, ROWS);
    	graphCols = createGraph(stones, COLS);
    	
        for(int[] c: stones){
            // traverse it
        	List<Integer> current = new ArrayList<>();
        	current.add(c[0]);
        	current.add(c[1]);
            if (canBeRemoved(current)){
                taken.add(current);
                System.out.println("Yes." + current + " has been taken");
            }
        }
        
        return taken.size();

    }
    
    /**
     * Creates the graph which is going  to be traversed
     * @param in[][]
     * @param boolean
     * @return Map<Integer, List<Integer>>
     * */
    public static Map<Integer, List<Integer>> createGraph(int[][] stones, boolean rowsOrCols){
        Map<Integer, List<Integer>> map  = new HashMap<>();
        // Create the graph
        for(int stone[]: stones){
        	int k = stone[0];
            int v = stone[1];
            
        	if(rowsOrCols) {
        		k = stone[1];
                v = stone[0];
        	}
        	
        	List<Integer> list = new ArrayList<>();
            if(map.containsKey(k))
            	list = map.get(k);

            list.add(v);
            map.put(k, list);

        }
        
        return map;
        
    }
    
    /**
     * Returns true if the stone can be removed. False otherwise. Is it possible to me removed
     * if its rows or columns match with any other stone that has not been taken before.
     * @param List<Integer>
     * @param boolean
     * */
    public static boolean canBeRemoved(List<Integer> stone){
        System.out.println("Can " + stone + " be removed?");
        int k = stone.get(0);
        int v = stone.get(1);
        
        // Look for the key in the graph
        if(graphRows.containsKey(k)){
            System.out.println("possibles stones: (by key)");
            
            for(int value: graphRows.get(k)){
            	List<Integer> possible = new ArrayList<>();
            	possible.add(k);
            	possible.add(value);
                System.out.println("\t " +  possible);

                if(!taken.contains(possible) && !possible.equals(stone))
                    return true;
            }
        }
        
        // Look for the value as key in the graph
        if(graphCols.containsKey(v)){
            System.out.println("possibles stones: (by value)");
            
            for(int value: graphCols.get(v)){
            	List<Integer> possible = new ArrayList<>();
            	possible.add(value)
            	possible.add(v);
                System.out.println("\t " +  possible);
                
                if(!taken.contains(possible) && !possible.equals(stone))
                    return true;
            }
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		int[][] arr = {{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}};
		//int[][] arr = {{0,0},{0,2},{1,1},{2,0},{2,2}};
		//int[][] arr = {{0,1},{1,0}};
		System.out.println( removeStones(arr) );
		
	}

}
