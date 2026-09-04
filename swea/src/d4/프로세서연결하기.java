package d4;

public class 프로세서연결하기 {
	static int max_length;
	static int N;
	static int[] dr = new int[]{-1,1,0,0};
	static int[] dc = new int[]{0,0,-1,1};
	static int[][] cores; // [[y,x] [y,x] ....] 각 코어 좌표
	static int[][] arr;
	
	public static void main(String[] args) {
		
		connect(0, dr[0], dc[0], 0);
		connect(0, dr[1], dc[1], 0);
		connect(0, dr[2], dc[2], 0);
		connect(0, dr[3], dc[3], 0);
		
	}
	
	//상하좌우 중 뻗음 
	static void connect(int i, int dirR, int dirC, int currentLength) {
		int a = cores[i][0];
		int b = cores[i][1]; //코어위치
		int r = a+dirR;
		int c = b+dirC;
		
		while(r>=0 && r<N && c>=0 && c<N) {
			if(arr[r][c] == 1) return;
			
			
			arr[r][c] = 1;
			currentLength++;
			
			r += dirR;
			c += dirC;
		}
		
		
		connect(i+1, dr[0], dc[0], currentLength);
		connect(i+1, dr[1], dc[1], currentLength);
		connect(i+1, dr[2], dc[2], currentLength);
		connect(i+1, dr[3], dc[3], currentLength);
	}

}





	
	