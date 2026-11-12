package A형기출;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 헌터2 {
	static int N;
	static Map<Integer, int[]> location;
	static Map<Integer, Boolean> visited;
	static Map<Integer, Integer> indegree;
	static int minDist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			location = new HashMap<>();
			visited = new HashMap<>();
			indegree = new HashMap<>();
			minDist = Integer.MAX_VALUE;
			
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int value = sc.nextInt();
					if(value != 0) {
						location.put(value, new int[]{r, c});
						visited.put(value, false);
						indegree.put(value, (value>0 ? 0 : 1));
					}
				}
			}
			
			dfs(0, 0, 0, 0);

			System.out.println("#" + t + " " + minDist);	
		}
	}
	
	//순열
	public static void dfs(int cr, int cc, int currDist, int cnt) {
		if(cnt == location.keySet().size()) {
			if(currDist < minDist) minDist = currDist;
			return;
		}
		
		if(currDist >= minDist) {
			return;
		}
		
		for(int key : indegree.keySet()) {
			if(visited.get(key)) continue;
			if(indegree.get(key) == 0) {
				visited.put(key, true);
				if(key > 0) { //몬스터일시
					indegree.put(-key, 0); //의뢰인 진입차수 감소
				}
				int nr = location.get(key)[0];
				int nc = location.get(key)[1];
				int dist = Math.abs(cr - nr) + Math.abs(cc - nc);
				
				dfs(nr, nc, currDist+dist, cnt+1);
				
				visited.put(key, false);
				if(key > 0) {
					indegree.put(-key, 1);
				}
				
			}
		}	
	}

}
