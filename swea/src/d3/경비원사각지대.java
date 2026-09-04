package d3;

import java.util.Scanner;

public class 경비원사각지대 {
	static int[][] arr;
	static int N;
	static int posY, posX;
	static int unchecked, checked;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			checked = 0;
			unchecked = 0;
			N = sc.nextInt();
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 0) {
						unchecked++;
					} else if (arr[i][j] == 2) {
						posY = i;
						posX = j;
					}
				}
			}
			
			System.out.println("0 개수: " + unchecked);
			
			observe(+1, 0);
			observe(-1, 0);
			observe(0, +1);
			observe(0, -1);
			
			unchecked -= checked;
			System.out.println(unchecked);
		}
	}



	static void observe(int dy, int dx) {
		int y = posY+dy;
		int x = posX+dx;
		
		while(y>=0 && y<N && x>=0 && x<N) {
			
			if(arr[y][x] == 1) break;
			if(arr[y][x] == 0) checked ++;
			
			y += dy;
			x += dx;
		}
	}
}




