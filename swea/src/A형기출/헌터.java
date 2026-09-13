package A형기출;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class 헌터 {
	static int[][] arr;
	static HashMap<Integer, Integer> indegree; 
	static HashMap<Integer, int[]> location; // -4 : 좌표, ... 4 : 좌표
	static HashMap<Integer, Boolean> visited;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			ans = Integer.MAX_VALUE;
			arr = new int[N][N];
			indegree= new HashMap<Integer, Integer>();
			location = new HashMap<Integer, int[]>();
			visited = new HashMap<Integer, Boolean>();
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
					if(arr[r][c] != 0) {
						location.put(arr[r][c], new int[] {r, c});
						indegree.put(arr[r][c], arr[r][c] < 0 ? 1 : 0);
						visited.put(arr[r][c], false);
					}
				}
			}
			
			dfs(0, 0, 0, 0);
			
			System.out.println("#" + t + " " + ans);
			
		}
		
		
		
	}	
		
	//indegree가 0인곳부터 방문하는 dfs	
	static void dfs(int r, int c, int currDistance, int cnt) {
		if(currDistance >= ans) return; //최소값 초과시 백트래킹
		
		if(cnt == location.keySet().size()) { //모두방문 시 최소값갱신
			 ans = currDistance;
			 return;
		}
		
		for(int next : indegree.keySet()) { 
			if(indegree.get(next) != 0) continue;
			if(visited.get(next)) continue;
			
			int distance = Math.abs(r - location.get(next)[0])
			         + Math.abs(c - location.get(next)[1]);
			visited.put(next, true);
			if(next > 0) indegree.put(-next, indegree.get(-next)-1); //몬스터일시 의뢰인 진입차수 1 감소
			dfs(location.get(next)[0], location.get(next)[1], currDistance + distance, cnt+1);
			visited.put(next, false);
			if(next > 0) indegree.put(-next, indegree.get(-next)+1);
		}
	}
	
	
}
