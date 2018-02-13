package crackingcode;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,0,1},{1,1,1},{0,1,1}};
		Utilities.displayMatrix(arr);
		setZeros(arr);
		Utilities.displayMatrix(arr);
		
	}
	
	public static void setZeros(int[][] matrix){
		if(matrix==null){
			return;
		}
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];
		
		for(int i=0; i<matrix.length ;i++){
			for(int j=0; j<matrix[0].length ;j++){
				if(matrix[i][j]==0){
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		
		for(int i=0; i<matrix.length ;i++){
			for(int j=0; j<matrix[0].length ;j++){
				if(rows[i] || columns[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}

}
