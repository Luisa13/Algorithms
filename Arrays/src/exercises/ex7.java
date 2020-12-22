package exercises;
// import javafx.util.Pair; 


public class ex7 {

	static final int N = 3;
	static int[][] rotateMatrix(int m[][], int N){
		
		for(int i =0; i < N; i++) {
			int n = N -1;
			for(int j = i; j < n; j ++) {
				m = swapValue(m, i, j, j, n);
				m = swapValue(m, i, j, n, (n-j)+i);
				m = swapValue(m, i, j, (n-j)+i, i);
			}
			N--;
		}
		
		return m;
	}
	
	//TODO: change parameters origin and destiny as PAIR (can be found in JavaFX library)
	static int[][] swapValue(int m[][], int originX, int originY, int destX, int destY ){
		int aux = m[destX][destY];
		m[destX][destY] = m[originX][originY];
		m[originX][originY] = aux;
		
		return m;
	}
	
	public static void main(String[] args) {
		//TODO Test
	}
}
