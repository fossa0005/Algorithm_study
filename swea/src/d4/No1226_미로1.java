package d4;

import java.util.Scanner;

public class No1226_미로1 {
	static int ans;
	static int[][] arr = new int[16][16];
	static int[] dy = new int[]{-1, +1, 0, 0};
	static int[] dx = new int[]{0, 0, -1, +1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int t=1; t<=10; t++) {
			sc.nextInt();
			ans = 0;
			
			int startY = 0, startX = 0;
			for(int r=0; r<16; r++) {
				String row  = sc.next();
				for(int c=0; c<16; c++) {
					int n = row.charAt(c) - '0';
					arr[r][c] = n;
					if(arr[r][c] == 2) {
						startY = r;
						startX = c;
					}
				}
			}
			
			arr[startY][startX] = 1;
			dfs(startY, startX);
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	
	static void dfs(int currY, int currX) {
		
		if(ans == 1) return; //도달할 수 있는 한 경우의 수 찾았으면 더이상 탐색 불필요
		 
		
		for(int i=0; i<4; i++) {
			if(arr[currY+dy[i]][currX+dx[i]] == 1) continue;
			if(arr[currY+dy[i]][currX+dx[i]] == 3) {
				ans = 1;
				return;
			}
			
			arr[currY+dy[i]][currX+dx[i]] = 1; //다음노드 방문처리
			dfs(currY+dy[i], currX+dx[i]); //다음 노드의 자식 경우의수 완전탐색
		}
	}
	
	
}
