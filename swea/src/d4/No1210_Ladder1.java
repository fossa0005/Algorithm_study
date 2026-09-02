package d4;

import java.util.Scanner;

public class No1210_Ladder1 {
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = 10;
		
		for(int t=1; t<=testCase; t++) {
			sc.nextInt();
			arr = new int[100][100];
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}	
			}
			
			int ans=0;
			for(int i=0; i<100; i++) {
				
				if(arr[0][i] == 1) {
					//System.out.println("시작점: " + i);
					if (goDownTo2(i)) {
						ans = i;
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		
		

	}
	




	static boolean goDownTo2(int b) {
		int y=0;
		int x=b;
		int dy = +1;
		
		while(y<99) {
			//아래방향으로 내려가고있던 중에만(dy=+1) 좌우방향전환해야함. 
			if(dy == 1 && x+1 < 100 && arr[y][x+1] == 1) {   
				dy = 0;
				do { x++; } while (arr[y+1][x]==0);
				
				//System.out.println(y + " " + x);
				continue;
			}
			
			if(dy == 1 && x-1 >= 0 && arr[y][x-1] == 1) {
				dy = 0;
				do { x--; } while (arr[y+1][x]==0);
				//System.out.println(y + " " + x);
				continue;
			}
			
			dy = +1;
			y += dy;
			
			//System.out.println(y + " " + x);
		}
		
		return arr[y][x] == 2;
		
	}
}



