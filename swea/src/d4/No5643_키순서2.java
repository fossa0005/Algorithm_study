package d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class No5643_키순서2 {
	static int N, M;
	static List<Integer>[] bigger;
	static List<Integer>[] smaller;
	static boolean[] visited;
	static int cnt, bigger_cnt, smaller_cnt;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			bigger = new ArrayList[N];
			smaller = new ArrayList[N];
			visited = new boolean[N];
			res = 0;
			
			for(int i=0; i<N; i++) {
				bigger[i] = new ArrayList<Integer>();
				smaller[i] = new ArrayList<Integer>();
			}
			
			//그래프작성
			for(int m=0; m<M; m++) {
				int small = sc.nextInt() - 1 ;
				int big = sc.nextInt() - 1;
				
				bigger[small].add(big);
				smaller[big].add(small);
			}
			
			
			for(int i=0; i<N; i++) {
				//i번보다 더 큰 사람 모두세기
				cleanVisited();
				cnt = 0;
				count(i, bigger);
				bigger_cnt = cnt;
				
				//i번보다 작은 사람 모두세기
				cleanVisited();
				cnt = 0;
				count(i, smaller);
				smaller_cnt = cnt;
			
				if(bigger_cnt + smaller_cnt == N - 1) res++;
			}
			
			System.out.println("#" + t + " " + res);
			
		}
		
		
	}
	
	public static void count(int i, List<Integer>[] graph) {
		for(int adjacent : graph[i]) {
			if(visited[adjacent]) continue;
			visited[adjacent] = true;
			cnt++;
			count(adjacent, graph);
		}
		
	}
	
	public static void cleanVisited() {
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
	}

}


