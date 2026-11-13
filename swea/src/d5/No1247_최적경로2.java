package d5;

import java.util.Arrays;
import java.util.Scanner;

public class No1247_최적경로2 {
	static int N;
	static int ir, ic; //시작 회사 좌표
	static int dr, dc; //집 좌표
	static int[][] customers; //고객좌표
	static boolean[] visited;
	static int minDist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			customers = new int[N][];
			visited = new boolean[N];
			minDist = Integer.MAX_VALUE;
				
			ic = sc.nextInt();
			ir = sc.nextInt();
		
			dc = sc.nextInt();
			dr = sc.nextInt();
			
			for(int n=0; n<N; n++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				customers[n] = new int[]{r, c}; 
			}
			
			//System.out.println(Arrays.deepToString(customers));
			dfs(ir, ic, 0, 0);
			
			System.out.println("#" + t + " " + minDist);
		}
		
		
	}
	
	//순열
	static void dfs(int cr, int cc, int currDist, int cnt) {
		if(cnt == N) {
			int dist = Math.abs(dr - cr) + Math.abs(dc - cc);
			currDist += dist;
			if(currDist < minDist) minDist = currDist;
			return;
		}
		
		if(currDist >= minDist) return;
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			int nr = customers[i][0];
			int nc = customers[i][1];
			int dist =  Math.abs(nr - cr) + Math.abs(nc - cc);
			visited[i] = true;
			dfs(nr, nc, currDist+dist, cnt+1);
			visited[i] = false;
		}
	}

}
