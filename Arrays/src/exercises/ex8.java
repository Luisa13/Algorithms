package exercises;

import java.util.HashSet;
import java.util.Set;

public class ex8 {

	
	static int[][] getZeroMatrix(int m[][], int M, int N){
		Set<Integer> rows = new HashSet<>();
		Set<Integer> columns = new HashSet<>();
		
		//Read the matriz to know where the 0 are
		for (int i = 0; i < M; i ++) {
			for(int j = 0; j <N; j++) {
				if(m[i][j] == 0)
				{
					rows.add(i);
					columns.add(j);
				}
			}
		}
		
		//Fill the columns up
		for(int col: columns) {
			for(int i= 0; i< M; i++)
				m[i][col] = 0;
		}
		
		//Fill the rows up
		for(int row: rows) {
			for(int i = 0; i< N; i++)
				m[row][i] = 0;
		}
		
		return m;

	}
	public static void main(String[] args) {
		// TODO Test matrix Zero

	}

}
