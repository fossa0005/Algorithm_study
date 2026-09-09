package d5;

import java.util.Scanner;


public class No1247_최적경로 { //순열문제
	static int N;
	static int[][] customers; //고객 좌표
	static int[] home = new int[2];
	static int[] company = new int[2];
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
			
			company[0] = sc.nextInt();
			company[1] = sc.nextInt();
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			customers = new int[N][];
			for(int i=0; i<N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				customers[i] = new int[]{x,y}; 
			}
			
			
			for(int i=0; i<N; i++) {
				dfs(i, 0, 0, 0);
			}
			
			
			System.out.println("#" + t + " " + minDistnace);
		}
		
	}
	
	static void dfs(int i, int prior, int cnt, int currDistance) {
		
		visited[i] = true;
		cnt++;
		
		if (cnt == 1) currDistance += Math.abs(customers[i][0] - company[0]) +  Math.abs(customers[i][1] - company[1]);
		else currDistance += Math.abs(customers[i][0] - customers[prior][0]) +  Math.abs(customers[i][1] - customers[prior][1]); 
		
		if(currDistance > minDistnace) {
			visited[i] = false;
			return;
		}
		
		if(cnt==N) { //모든 고객 다 봄
			currDistance += Math.abs(customers[i][0] - home[0]) +  Math.abs(customers[i][1] - home[1]);
			if(currDistance < minDistnace) minDistnace = currDistance;
			visited[i] = false;
			return;
		}
		
		
		for(int j=0; j<N; j++) {
			if(visited[j] == true) continue;
			dfs(j, i, cnt, currDistance);
		}
		
		visited[i] = false; //초기화
		
	}

}
