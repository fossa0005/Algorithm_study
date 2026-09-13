package d5;

import java.util.Scanner;


public class No1247_최적경로 { //순열문제
	static int N;
	static int[][] customers; //고객 좌표
	static int[] home = new int[2];
	static int[] work = new int[2];
	static boolean[] visited;
	static int minDistnace;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//T
		//고객수
		//회사 집 고객1, 고객2, ....
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			
			minDistnace = Integer.MAX_VALUE;
			visited = new boolean[N]; 
			
			work[0] = sc.nextInt();
			work[1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			customers = new int[N][];
			for(int i=0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				customers[i] = new int[]{x,y}; 
			}
			
			
			for(int i=0; i<N; i++) {
				visited[i] = true;
				int currDistance = Math.abs(customers[i][0] - work[0]) +  Math.abs(customers[i][1] - work[1]);
				dfs(i, 1, currDistance);
				visited[i] = false;
			}
			
			System.out.println("#" + t + " " + minDistnace);
		}
		
	}
	
	static void dfs(int i, int cnt, int currDistance) {
		
		
		//최소거리 초과시 백트래킹
		if(currDistance >= minDistnace) {
			return;
		}
		
		//모든 고객 다 봄
		if(cnt==N) { 
			currDistance += Math.abs(customers[i][0] - home[0]) 
						+ Math.abs(customers[i][1] - home[1]);
			if(currDistance < minDistnace) minDistnace = currDistance;
			return;
		}
		
		//i=1, j=2일때 1-2-3-...  여기서 2를 방문처리한걸 초기화안하면 
		//i=1, j=3일때 1-3-2-.... 이 경우의수가 탐색이 안됨
		//j 방문처리는 for문 한번에 대해서만 유지되어야함
		for(int j=0; j<N; j++) {
			if(visited[j] == true) continue;
			visited[j] = true;
			int distance = Math.abs(customers[i][0] - customers[j][0]) 
						+ Math.abs(customers[i][1] - customers[j][1]);  
			dfs(j, cnt+1, currDistance + distance);
			visited[j] = false;
		}
	}

}
